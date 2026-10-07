abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {

    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {

        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }
}

class Train extends Transport {

    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + (0.15 * distance);
    }
}

class Metro extends Transport {

    double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class TransportFareCalculator {

    public static void main(String[] args) {

        Transport[] transports = {
            new Bus(20),
            new Train(20),
            new Metro(20, 1.5)
        };

        for (Transport transport : transports) {
            System.out.println("Fare: " + transport.calculateFare());
        }
    }
}