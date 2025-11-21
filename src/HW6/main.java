package HW6;

public class main {
    public static void main(String[] args) {
        Library<Library.Section> library = new Library<>();

        Library.Section fiction = new Library.Section("Fiction");
        Library.Section science = new Library.Section("Science");

        Library<Library.Section>.Book b1 = library.new Book("The Martian", "Andy Weir", 2011);
        Library<Library.Section>.Book b2 = library.new Book("Project Hail Mary", "Andy Weir", 2021);
        Library<Library.Section>.Book b3 = library.new Book("A Brief History of Time", "Stephen Hawking", 1988);

        fiction.addBook(b1);
        fiction.addBook(b2);
        science.addBook(b3);

        library.addSection(fiction);
        library.addSection(science);

        library.displayAllSections();

        library.filterBooks(new BookFilter() {
            @Override
            public boolean filter(Library<?>.Book book) {
                return book.getYear() > 2015;
            }
        });
    }
}