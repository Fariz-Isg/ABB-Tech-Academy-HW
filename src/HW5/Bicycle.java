package HW5;

public class Bicycle implements Transport {
    private final double ratePerKm = 0.1;
    private final double speed = 15;

    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public double calculateFare(double distance, int passengers) {
        return distance * ratePerKm * (passengers / 2 + 1);
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed;
    }

    @Override
    public String getTransportInfo() {
        return "Bicycle's speed is " + speed + ", and rate Per Kilometer is " + ratePerKm;
    }
}
