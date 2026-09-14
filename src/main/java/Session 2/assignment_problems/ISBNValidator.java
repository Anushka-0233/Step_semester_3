import java.util.Scanner;

public class ISBNValidator {

    // Normalize the code
    public static String normalizeCode(String raw) {

        raw = raw.trim();

        if (raw.length() < 3) {
            return raw;
        }

        String publisherCode =
                raw.substring(0, 3)
                   .toUpperCase();

        String remaining =
                raw.substring(3);

        return publisherCode + remaining;
    }


    // Validate and format the code
    public static String validateAndFormat(
            String code) {

        // Check length
        if (code.length() != 13) {

            return "Invalid: wrong length";
        }


        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(
                    code.charAt(i))) {

                return
                    "Invalid: publisher code must be 3 letters";
            }
        }


        // Check remaining characters are digits
        for (int i = 3;
             i < code.length();
             i++) {

            if (!Character.isDigit(
                    code.charAt(i))) {

                return
                    "Invalid: body must contain only digits";
            }
        }


        String publisherCode =
                code.substring(0, 3);

        String year =
                code.substring(3, 7);

        String catalog =
                code.substring(7, 13);


        StringBuilder result =
                new StringBuilder();

        result.append("[");
        result.append(publisherCode);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalog);

        return result.toString();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print(
            "Enter ISBN code: "
        );

        String raw = sc.nextLine();

        String normalized =
                normalizeCode(raw);

        String result =
                validateAndFormat(normalized);

        System.out.println(result);

        sc.close();
    }
}