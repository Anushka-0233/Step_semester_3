import java.util.Scanner;

public class TransactionReference {

    // Normalize the reference
    public static String normalizeReference(
            String raw) {

        raw = raw.trim();

        if (raw.length() < 3) {
            return raw;
        }

        String bankCode =
                raw.substring(0, 3).toUpperCase();

        String remaining =
                raw.substring(3);

        return bankCode + remaining;
    }


    // Validate and format the reference
    public static String validateAndFormat(
            String reference) {

        // Check length
        if (reference.length() != 14) {

            return "Invalid: wrong length";
        }


        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(
                    reference.charAt(i))) {

                return
                    "Invalid: bank code must be 3 letters";
            }
        }


        // Check remaining characters are digits
        for (int i = 3;
             i < reference.length();
             i++) {

            if (!Character.isDigit(
                    reference.charAt(i))) {

                return
                    "Invalid: body must contain only digits";
            }
        }


        // Get different parts
        String bankCode =
                reference.substring(0, 3);

        String day =
                reference.substring(3, 5);

        String month =
                reference.substring(5, 7);

        String year =
                reference.substring(7, 9);

        String sequence =
                reference.substring(9, 14);


        // Build formatted output
        StringBuilder result =
                new StringBuilder();

        result.append("[");
        result.append(bankCode);
        result.append("] DATE: ");

        result.append(day);
        result.append("/");

        result.append(month);
        result.append("/");

        result.append(year);

        result.append(" | SEQ: ");

        result.append(sequence);

        return result.toString();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print(
            "Enter transaction reference: "
        );

        String raw = sc.nextLine();


        String normalized =
                normalizeReference(raw);


        String result =
                validateAndFormat(normalized);


        System.out.println(result);

        sc.close();
    }
}