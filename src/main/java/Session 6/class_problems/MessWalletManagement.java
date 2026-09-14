class MessWallet {

    private double balance;


    // Constructor
    public MessWallet(double openingBalance) {

        if (openingBalance < 0) {

            balance = 0;

            System.out.println(
                "Warning: Negative opening balance. Starting with 0."
            );

        } else {

            balance = openingBalance;
        }
    }


    // Add money
    public void topUp(double amount) {

        if (amount <= 0) {

            System.out.println(
                "Invalid top-up amount"
            );

        } else {

            balance = balance + amount;

            System.out.println(
                "Balance after top-up: " +
                balance
            );
        }
    }


    // Deduct money
    public void deduct(double amount) {

        if (amount <= 0) {

            System.out.println(
                "Invalid deduction amount"
            );

        } else if (amount > balance) {

            System.out.println(
                "Deduct rejected: insufficient balance"
            );

        } else {

            balance = balance - amount;

            System.out.println(
                "Amount deducted successfully"
            );
        }
    }


    // Getter method
    public double getBalance() {

        return balance;
    }
}


public class MessWalletManagement {

    public static void main(String[] args) {

        MessWallet wallet =
                new MessWallet(500);


        wallet.topUp(200);

        wallet.deduct(1000);


        System.out.println(
            "Final balance: " +
            wallet.getBalance()
        );
    }
}