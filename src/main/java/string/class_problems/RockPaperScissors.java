import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") &&
             computerMove.equalsIgnoreCase("Scissors")) ||

            (playerMove.equalsIgnoreCase("Paper") &&
             computerMove.equalsIgnoreCase("Rock")) ||

            (playerMove.equalsIgnoreCase("Scissors") &&
             computerMove.equalsIgnoreCase("Paper"))) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        int rounds = 5;

        System.out.println("ROCK PAPER SCISSORS GAME");

        System.out.println("\nRound\tPlayer\t\tComputer\tResult");

        for (int i = 1; i <= rounds; i++) {

            System.out.print("Enter Rock, Paper or Scissors: ");
            String playerMove = sc.next();

            String computerMove = moves[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } 
            else if (result.equals("Computer Wins")) {
                losses++;
            } 
            else {
                draws++;
            }

            System.out.println(i + "\t" + playerMove +
                    "\t\t" + computerMove +
                    "\t\t" + result);
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("\nFINAL SUMMARY");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");

        sc.close();
    }
}