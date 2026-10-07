abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateFee();
}

class CardPayment extends Payment {

    CardPayment(double amount) {
        super(amount);
    }

    double calculateFee() {
        return amount * 0.02;
    }
}

class WalletPayment extends Payment {

    WalletPayment(double amount) {
        super(amount);
    }

    double calculateFee() {
        return amount * 0.01;
    }
}

class BankTransferPayment extends Payment {

    BankTransferPayment(double amount) {
        super(amount);
    }

    double calculateFee() {
        return 0;
    }
}

public class PaymentSystem {

    public static void main(String[] args) {

        Payment[] payments = {
            new CardPayment(1000),
            new WalletPayment(1000),
            new BankTransferPayment(1000)
        };

        for (Payment payment : payments) {
            System.out.println("Payment Amount: " + payment.amount);
            System.out.println("Fee: " + payment.calculateFee());
            System.out.println();
        }
    }
}