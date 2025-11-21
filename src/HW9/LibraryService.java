package HW9;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {
    private List<Book> books;
    private List<User> users;

    public LibraryService(List<Book> books, List<User> users) {
        this.books = books;
        this.users = users;
    }

    public void sortBooks() {
        System.out.println("Sorted Books:");
        books.stream()
                .sorted(Comparator.comparing(Book::getRating).reversed()
                        .thenComparing(Book::getYear)
                        .thenComparing(Book::getTitle))
                .forEach(b -> System.out.println("  " + b));
    }

    public void analyzeLibrary() {
        System.out.println("\nLibrary Analysis:");

        double avgRating = books.stream()
                .mapToDouble(Book::getRating)
                .average()
                .orElse(0.0);
        System.out.println("  Average Rating: " + avgRating);

        List<Book> modernAvailable = books.stream()
                .filter(b -> b.getYear() > 2000 && b.isAvailable())
                .collect(Collectors.toList());
        System.out.println("  Available after 2000: " + modernAvailable);

        Map<String, Long> borrowCounts = users.stream()
                .flatMap(u -> u.getBorrowHistory().stream())
                .collect(Collectors.groupingBy(
                        r -> r.getBook().getTitle(),
                        Collectors.counting()
                ));

        borrowCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e -> System.out.println("  Most borrowed book: " +
                        e.getKey() + " (" + e.getValue() + " times)"));

        Map<String, List<Book>> currentlyReading = users.stream()
                .collect(Collectors.toMap(
                        User::getName,
                        u -> u.getBorrowHistory().stream()
                                .filter(r -> r.getReturnedDate() == null)
                                .map(BorrowRecord::getBook)
                                .collect(Collectors.toList())
                ));
        System.out.println("  Currently reading:");
        currentlyReading.forEach((name, bookList) ->
                System.out.println("    " + name + " -> " + bookList));

        Map<String, List<Book>> booksByAuthor = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getAuthor,
                        Collectors.filtering(b -> b.getYear() > 1950, Collectors.toList())
                ));
        System.out.println("  Books grouped by author (after 1950):");
        booksByAuthor.entrySet().stream()
                .filter(e -> !e.getValue().isEmpty())
                .forEach(e -> System.out.println("    " + e.getKey() + " -> " + e.getValue()));
    }

    public Optional<Book> findRecommendedBookForUser(User user) {
        if (user.getBorrowHistory().isEmpty()) {
            return Optional.empty();
        }

        Optional<String> favoriteAuthor = user.getBorrowHistory().stream()
                .collect(Collectors.groupingBy(
                        r -> r.getBook().getAuthor(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);

        return favoriteAuthor.flatMap(author ->
                books.stream()
                        .filter(b -> b.getAuthor().equals(author) && b.isAvailable())
                        .max(Comparator.comparing(Book::getRating))
        );
    }

    public void uniqueAuthorsRead() {
        Set<String> uniqueAuthors = users.stream()
                .flatMap(u -> u.getBorrowHistory().stream())
                .map(r -> r.getBook().getAuthor())
                .collect(Collectors.toSet());

        System.out.println("\nAuthors read by users: " + uniqueAuthors);
    }

    public Optional<User> findTopReaderOfMonth(int month, int year) {
        return users.stream()
                .max(Comparator.comparingLong(u ->
                        u.getBorrowHistory().stream()
                                .filter(r -> r.getBorrowedDate().getMonthValue() == month &&
                                        r.getBorrowedDate().getYear() == year)
                                .count()
                ))
                .filter(u -> u.getBorrowHistory().stream()
                        .anyMatch(r -> r.getBorrowedDate().getMonthValue() == month &&
                                r.getBorrowedDate().getYear() == year));
    }
}
