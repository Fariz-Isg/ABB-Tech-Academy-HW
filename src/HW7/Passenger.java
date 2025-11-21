package HW7;

public class Passenger {
    private final String name;
    private final boolean isPriority;

    public Passenger(String name, boolean isPriority) {
        this.name = name;
        this.isPriority = isPriority;
    }

    public String getName() {
        return name;
    }

    public boolean isPriority() {
        return isPriority;
    }

    @Override
    public String toString() {
        return isPriority ? name + "(PRIORITY)" : name;
    }
}