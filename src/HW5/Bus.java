package HW5;

public class Bus implements Transport {
    private final double ratePerKm = 0.60;
    private final double speed = 50;

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public double calculateFare(double distance, int passengers) {
        return distance * ratePerKm * passengers;
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed;
    }

    @Override
    public String getTransportInfo() {
        return "Bus's speed is " + speed + ", and rate Per Kilometer is " + ratePerKm;
    }
}
