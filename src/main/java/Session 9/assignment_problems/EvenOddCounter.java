import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        input = input.replace("[", "").replace("]", "").trim();

        int even = 0, odd = 0;

        if (!input.isEmpty()) {
            String[] numbers = input.split(",");

            for (int i = 0; i < numbers.length; i++) {
                int number = Integer.parseInt(numbers[i].trim());

                if (number % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);

        sc.close();
    }
}