import java.util.Scanner;

public class PalindromeChecker {

    // 1. Iterative method
    public static boolean isPalindromeIterative(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {

            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }


    // 2. Recursive method
    public static boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(
                text.substring(1, text.length() - 1)
        );
    }


    // 3. Array reversal method
    public static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();
        char[] reversed = new char[text.length()];

        int j = 0;

        for (int i = original.length - 1; i >= 0; i--) {
            reversed[j] = original[i];
            j++;
        }

        for (int i = 0; i < original.length; i++) {

            if (original[i] != reversed[i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String text = sc.nextLine();

        if (isPalindromeIterative(text)) {
            System.out.println("Iterative: Palindrome");
        } else {
            System.out.println("Iterative: Not Palindrome");
        }

        if (isPalindromeRecursive(text)) {
            System.out.println("Recursive: Palindrome");
        } else {
            System.out.println("Recursive: Not Palindrome");
        }

        if (isPalindromeArrayReversal(text)) {
            System.out.println("Array Reversal: Palindrome");
        } else {
            System.out.println("Array Reversal: Not Palindrome");
        }

        sc.close();
    }
}