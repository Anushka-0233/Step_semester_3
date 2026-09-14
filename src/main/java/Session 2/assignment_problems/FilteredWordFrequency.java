import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FilteredWordFrequency {

    public static void printFilteredWordFrequency(
            String feedback) {

        // Convert to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        // Split into words
        String[] words =
                feedback.split("\\s+");


        // Stop words
        String[] stopWords = {
            "the", "was", "and",
            "a", "is", "of", "in"
        };


        HashMap<String, Integer> frequency =
                new HashMap<>();


        // Count words
        for (int i = 0;
             i < words.length;
             i++) {

            boolean isStopWord = false;


            // Check stop words
            for (int j = 0;
                 j < stopWords.length;
                 j++) {

                if (words[i].equals(
                        stopWords[j])) {

                    isStopWord = true;
                    break;
                }
            }


            // Count non-stop words
            if (!isStopWord) {

                if (frequency.containsKey(
                        words[i])) {

                    frequency.put(
                        words[i],
                        frequency.get(
                            words[i]) + 1
                    );
                }
                else {

                    frequency.put(
                        words[i], 1
                    );
                }
            }
        }


        // Convert keys into list
        ArrayList<String> wordList =
                new ArrayList<>(
                    frequency.keySet()
                );


        // Sort by frequency in descending order
        Collections.sort(
            wordList,
            new Comparator<String>() {

                public int compare(
                        String word1,
                        String word2) {

                    return frequency.get(word2) -
                           frequency.get(word1);
                }
            }
        );


        // Print result
        for (String word : wordList) {

            System.out.println(
                word + ": " +
                frequency.get(word)
            );
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(
            "Enter feedback:"
        );

        String feedback = sc.nextLine();

        printFilteredWordFrequency(
            feedback
        );

        sc.close();
    }
}