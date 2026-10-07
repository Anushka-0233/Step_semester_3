import java.util.Scanner;

public class ElectricityConnectionBilling {

    static abstract class Connection {
        double units;

        Connection(double units) {
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class Home extends Connection {

        Home(double units) {
            super(units);
        }

        double calculateBill() {
            if (units <= 100) {
                return units * 5;
            }

            return (100 * 5) + ((units - 100) * 7);
        }
    }

    static class Shop extends Connection {

        Shop(double units) {
            super(units);
        }

        double calculateBill() {
            return (units * 8) + 100;
        }
    }

    static class Factory extends Connection {

        Factory(double units) {
            super(units);
        }

        double calculateBill() {
            return Math.max(units * 6, 1000);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double units = sc.nextDouble();

            Connection connection;

            if (type.equals("HOME")) {
                connection = new Home(units);
            } else if (type.equals("SHOP")) {
                connection = new Shop(units);
            } else {
                connection = new Factory(units);
            }

            double bill = connection.calculateBill();

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}