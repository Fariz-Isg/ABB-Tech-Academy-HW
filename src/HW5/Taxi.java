package HW5;

public class Taxi implements Transport{
    private final double ratePerKm = 4;
    private final double speed =90;

    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public double calculateFare(double distance, int passengers) {
        if (passengers <= 4) {
            return calculateFare(distance);
        }
        else {
            return 3 + calculateFare(distance);
        }
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed;
    }

    @Override
    public String getTransportInfo() {
        return "Taxi's speed is " + speed + ", and rate Per Kilometer is " + ratePerKm;
    }
}
