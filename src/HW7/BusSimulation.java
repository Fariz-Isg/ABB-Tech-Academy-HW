package HW7;

import java.util.*;

public class BusSimulation {
    private static final Random random = new Random();

    static void main() {
        Bus bus = new Bus();

        BusStop stop1 = createStop1();
        BusStop stop2 = createStop2();
        BusStop stop3 = createStop3();

        processStop(bus, stop1, 1);
        processStop(bus, stop2, 2);
        processStop(bus, stop3, 3);

        System.out.println("Simulation finished.");
        System.out.println("Final passengers in bus: " + bus.getPassengers());
    }

    private static void processStop(Bus bus, BusStop stop, int stopNumber) {
        System.out.println("Stop " + stopNumber + " reached.");

        bus.dropPassengers(random);

        while (!stop.isEmpty() && !bus.isFull()) {
            Passenger p = stop.removeNextPassenger();
            if (p != null) {
                bus.boardPassenger(p);
            }
        }

        System.out.println("Bus now: " + bus.getPassengers());
        System.out.println("Stop " + stopNumber + " remaining: " + stop.getRemainingPassengers());
    }

    private static BusStop createStop1() {
        BusStop stop = new BusStop();
        stop.addPassenger(new Passenger("Aysel", true));
        stop.addPassenger(new Passenger("Rauf", false));
        stop.addPassenger(new Passenger("Ali", false));
        return stop;
    }

    private static BusStop createStop2() {
        BusStop stop = new BusStop();
        stop.addPassenger(new Passenger("Nigar", true));
        stop.addPassenger(new Passenger("Samir", true));
        stop.addPassenger(new Passenger("Murad", false));
        return stop;
    }

    private static BusStop createStop3() {
        BusStop stop = new BusStop();
        stop.addPassenger(new Passenger("Sevinc", true));
        stop.addPassenger(new Passenger("Leyla", false));
        stop.addPassenger(new Passenger("Tural", false));
        return stop;
    }
}