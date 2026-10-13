import java.util.Scanner;
import java.util.Arrays;

public class InPlaceArrayReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        input = input.replace("[", "").replace("]", "").trim();

        int[] numbers;

        if (input.isEmpty()) {
            numbers = new int[0];
        } else {
            String[] parts = input.split(",");
            numbers = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i].trim());
            }
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(numbers));

        sc.close();
    }
}