import java.util.Scanner;

public class CityCabFareMeter {

    static abstract class Cab {
        double km;

        Cab(double km) {
            this.km = km;
        }

        abstract double getRate();

        boolean supportsNightService() {
            return false;
        }

        double calculateFare() {
            double fare = Math.max(km * getRate(), 100);

            return fare;
        }

        double calculateNightFare() {
            return calculateFare() * 1.20;
        }
    }

    static class Mini extends Cab {

        Mini(double km) {
            super(km);
        }

        double getRate() {
            return 10;
        }
    }

    static class Sedan extends Cab {

        Sedan(double km) {
            super(km);
        }

        double getRate() {
            return 14;
        }

        boolean supportsNightService() {
            return true;
        }
    }

    static class SUV extends Cab {

        SUV(double km) {
            super(km);
        }

        double getRate() {
            return 18;
        }

        boolean supportsNightService() {
            return true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new Mini(km);
            } else if (type.equals("SEDAN")) {
                cab = new Sedan(km);
            } else {
                cab = new SUV(km);
            }

            if (time.equals("NIGHT") && !cab.supportsNightService()) {

                System.out.println(type + ": night service not available");

            } else {

                double fare;

                if (time.equals("NIGHT")) {
                    fare = cab.calculateNightFare();
                } else {
                    fare = cab.calculateFare();
                }

                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}