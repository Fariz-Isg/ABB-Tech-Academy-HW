package HW8;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CarRentalSystem {
    private Set<Car> allCars;
    private Set<Car> availableCars;
    private Map<Customer, Car> activeRentals;
    private Map<Car, LocalDateTime> rentalStartTimes;
    private Map<Car, LocalDateTime> rentalHistory;

    public CarRentalSystem() {
        this.allCars = new HashSet<>();
        this.availableCars = new HashSet<>();
        this.activeRentals = new HashMap<>();
        this.rentalStartTimes = new HashMap<>();
        this.rentalHistory = new HashMap<>();
    }

    public void addCar(Car car) {
        allCars.add(car);
        availableCars.add(car);
    }

    public void rentCar(Customer customer, Car car) {
        if (!availableCars.contains(car)) {
            System.out.println("Car is not available!");
            return;
        }

        availableCars.remove(car);

        activeRentals.put(customer, car);

        LocalDateTime now = LocalDateTime.now();
        rentalStartTimes.put(car, now);

        System.out.println(customer.getName() + " rented " + car.getModel() + " at " + now);
    }

    public void returnCar(Customer customer) {
        if (!activeRentals.containsKey(customer)) {
            System.out.println("No active rental found for this customer!");
            return;
        }

        Car car = activeRentals.get(customer);
        LocalDateTime startTime = rentalStartTimes.get(car);
        LocalDateTime returnTime = LocalDateTime.now();

        Duration duration = Duration.between(startTime, returnTime);
        long days = duration.toDays();
        long hours = duration.toHours();

        activeRentals.remove(customer);
        rentalStartTimes.remove(car);

        availableCars.add(car);

        rentalHistory.put(car, returnTime);

        System.out.println(customer.getName() + " returned " + car.getModel() + " after " + days + " days (" + hours + " hours total)");
    }

    public void printActiveRentals() {
        System.out.println("Active Rentals:");
        if (activeRentals.isEmpty()) {
            System.out.println("No active rentals.");
        } else {
            for (Map.Entry<Customer, Car> entry : activeRentals.entrySet()) {
                Customer customer = entry.getKey();
                Car car = entry.getValue();
                LocalDateTime rentTime = rentalStartTimes.get(car);
                System.out.println(customer.getName() + " -> " + car.getModel() + " (rented at " + rentTime + ")");
            }
        }
    }

    public void printAvailableCars() {
        System.out.println("Available Cars:");
        if (availableCars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            for (Car car : availableCars) {
                System.out.println(car);
            }
        }
    }

    public void printHistory() {
        System.out.println("Rental History:");
        if (rentalHistory.isEmpty()) {
            System.out.println("No rental history.");
        } else {
            for (Map.Entry<Car, LocalDateTime> entry : rentalHistory.entrySet()) {
                Car car = entry.getKey();
                LocalDateTime returnTime = entry.getValue();
                System.out.println(car.getModel() + " was last returned at " + returnTime);
            }
        }
    }
}
