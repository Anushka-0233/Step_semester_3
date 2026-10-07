import java.util.Scanner;

public class CollegeFeeCounter {

    static abstract class Student {
        static final double TRANSPORT_FEE = 12000;

        String name;

        Student(String name) {
            this.name = name;
        }

        abstract double calculateTuition();

        boolean usesBus() {
            return false;
        }

        double calculateTotalFee() {
            double fee = calculateTuition();

            if (usesBus()) {
                fee += TRANSPORT_FEE;
            }

            return fee;
        }
    }

    static class DayScholar extends Student {

        DayScholar(String name) {
            super(name);
        }

        double calculateTuition() {
            return 40000;
        }

        boolean usesBus() {
            return true;
        }
    }

    static class Hosteller extends Student {

        Hosteller(String name) {
            super(name);
        }

        double calculateTuition() {
            return 40000 + 60000;
        }
    }

    static class Scholar extends Student {

        Scholar(String name) {
            super(name);
        }

        double calculateTuition() {
            return 20000;
        }

        boolean usesBus() {
            return true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new Scholar(name);
            }

            double fee = student.calculateTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);

        sc.close();
    }
}