package HW8;

public class Main {
    static void main() throws InterruptedException {
        CarRentalSystem system = new CarRentalSystem();
        Car c1 = new Car(1, "Toyota", "Camry", 2022);
        Car c2 = new Car(2, "BMW", "X5", 2023);
        Car c3 = new Car(3, "Hyundai", "Elantra", 2021);
        system.addCar(c1);
        system.addCar(c2);
        system.addCar(c3);
        Customer u1 = new Customer(101, "Aydin", "AZ12345");
        Customer u2 = new Customer(102, "Nigar", "AZ67890");
        system.rentCar(u1, c1);
        system.rentCar(u2, c2);
        system.printActiveRentals();
        system.printAvailableCars();
        system.returnCar(u1);
        system.printHistory();
        system.printAvailableCars();
    }
}
