package HW7;

import java.util.*;

public class Bus {
    private final Deque<Passenger> passengers;
    private static final int CAPACITY = 5;

    public Bus() {
        this.passengers = new LinkedList<>();
    }

    public boolean isFull() {
        return passengers.size() >= CAPACITY;
    }

    public int getAvailableSeats() {
        return CAPACITY - passengers.size();
    }

    public void dropPassengers(Random random) {
        if (passengers.isEmpty()) {
            return;
        }

        int toDrop = random.nextInt(3);
        toDrop = Math.min(toDrop, passengers.size());

        for (int i = 0; i < toDrop; i++) {
            Passenger p = passengers.pollFirst();
            if (p != null) {
                System.out.println(p.getName() + " left the bus.");
            }
        }
    }

    public void boardPassenger(Passenger p) {
        if (!isFull()) {
            passengers.offerLast(p);
            System.out.println(p + " boarded the bus.");
        }
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }
}