package HW5;

import java.util.Scanner;

public class TransportManager {

    public static Transport getTransport(TransportType type) {
        return switch (type) {
            case BICYCLE -> new Bicycle();
            case SCOOTER -> new Scooter();
            case TAXI -> new Taxi();
            case BUS -> new Bus();
            default -> null;
        };
    }

    static void main() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the type of transport: ");
        TransportType userChoice = TransportType.valueOf (input.nextLine().toUpperCase());
        Transport transport = getTransport(userChoice);
        System.out.print("Enter the distance: ");
        double distance = input.nextDouble();
        System.out.print("Enter the number of passengers : ");
        int passengers = input.nextInt();

        System.out.println("Transport Info: " + transport.getTransportInfo());
        System.out.println("Fare for " + passengers + " passenger(s): " + transport.calculateFare(distance));
        System.out.print("Estimated time: " + transport.calculateTime(distance) + " hours");

    }

}
