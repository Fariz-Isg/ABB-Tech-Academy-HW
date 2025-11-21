package HW7;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BusStop {
    private final Deque<Passenger> priorityQueue;
    private final Deque<Passenger> regularQueue;
    private static final int MAX_CAPACITY = 10;

    public BusStop() {
        this.priorityQueue = new LinkedList<>();
        this.regularQueue = new LinkedList<>();
    }

    public boolean addPassenger(Passenger p) {
        if (getTotalWaiting() >= MAX_CAPACITY) {
            return false;
        }
        if (p.isPriority()) {
            priorityQueue.offerLast(p);
        } else {
            regularQueue.offerLast(p);
        }
        return true;
    }

    public Passenger removeNextPassenger() {
        if (!priorityQueue.isEmpty()) {
            return priorityQueue.pollFirst();
        }
        if (!regularQueue.isEmpty()) {
            return regularQueue.pollFirst();
        }
        return null;
    }

    public int getTotalWaiting() {
        return priorityQueue.size() + regularQueue.size();
    }

    public List<Passenger> getRemainingPassengers() {
        List<Passenger> all = new ArrayList<>();
        all.addAll(priorityQueue);
        all.addAll(regularQueue);
        return all;
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty() && regularQueue.isEmpty();
    }
}