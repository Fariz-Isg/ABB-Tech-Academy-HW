package HW5;

public class Scooter implements Transport {
    private final double ratePerKm = 1.5;
    private final double speed = 30;

    public double calculateFare(double distance) {
        return 0.5 + distance * ratePerKm;
    }

    @Override
    public double calculateFare(double distance, int passengers) {
        return calculateFare(distance) * passengers;
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed;
    }

    @Override
    public String getTransportInfo() {
        return "Scooter's speed is " + speed + ", and rate Per Kilometer is " + ratePerKm;
    }
}
