import java.util.Arrays;

class Candidate
        implements Comparable<Candidate> {

    private String name;

    private double cgpa;

    private int codingScore;


    // Constructor
    public Candidate(
            String name,
            double cgpa,
            int codingScore) {

        this.name = name;

        this.cgpa = cgpa;

        this.codingScore =
                codingScore;
    }


    // CGPA-only eligibility
    public static boolean isEligible(
            double cgpa) {

        return cgpa >= 7.0;
    }


    // CGPA + Coding Score eligibility
    public static boolean isEligible(
            double cgpa,
            int codingScore) {

        return cgpa >= 6.5 &&
               codingScore >= 60;
    }


    // Composite score
    public double getCompositeScore() {

        return (cgpa * 10) +
                (codingScore / 2.0);
    }


    // Sort in descending order
    public int compareTo(
            Candidate other) {

        return Double.compare(
            other.getCompositeScore(),
            this.getCompositeScore()
        );
    }


    public String getName() {

        return name;
    }


    public static String shortlistAndRank(
            Candidate[] candidates) {

        // Count eligible candidates
        int count = 0;


        for (int i = 0;
             i < candidates.length;
             i++) {

            Candidate candidate =
                    candidates[i];


            if (isEligible(
                    candidate.cgpa) ||

                isEligible(
                    candidate.cgpa,
                    candidate.codingScore)) {

                count++;
            }
        }


        // Create shortlisted array
        Candidate[] shortlisted =
                new Candidate[count];


        int index = 0;


        // Add eligible candidates
        for (int i = 0;
             i < candidates.length;
             i++) {

            Candidate candidate =
                    candidates[i];


            if (isEligible(
                    candidate.cgpa) ||

                isEligible(
                    candidate.cgpa,
                    candidate.codingScore)) {

                shortlisted[index] =
                        candidate;

                index++;
            }
        }


        // Sort candidates
        Arrays.sort(shortlisted);


        String result = "";


        // Build ranking
        for (int i = 0;
             i < shortlisted.length;
             i++) {

            result = result +
                (i + 1) + ". " +
                shortlisted[i].getName() +
                " (" +
                shortlisted[i].getCompositeScore() +
                ")";


            if (i !=
                shortlisted.length - 1) {

                result = result + " | ";
            }
        }


        return result;
    }
}


public class PlacementRankingEngine {

    public static void main(String[] args) {

        Candidate[] candidates = {

            new Candidate(
                "Aisha", 8.2, 40
            ),

            new Candidate(
                "Rohit", 6.8, 65
            ),

            new Candidate(
                "Meena", 6.0, 90
            ),

            new Candidate(
                "Karan", 7.5, 20
            )
        };


        String result =
                Candidate.shortlistAndRank(
                    candidates
                );


        System.out.println(result);
    }
}