abstract class Delivery {
    double weight;
    double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class StandardDelivery extends Delivery {

    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {

    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {

    double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    double calculateFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class DeliveryFeeCalculator {

    public static void main(String[] args) {

        Delivery[] deliveries = {
            new StandardDelivery(5, 10),
            new ExpressDelivery(5, 10),
            new InternationalDelivery(5, 10, 20)
        };

        for (Delivery delivery : deliveries) {
            System.out.println("Delivery Fee: " + delivery.calculateFee());
        }
    }
}