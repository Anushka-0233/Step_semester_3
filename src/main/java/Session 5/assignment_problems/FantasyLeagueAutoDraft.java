import java.util.Arrays;

class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;


    // Constructor
    public Player(
            String name,
            int matchesPlayed,
            double battingAverage,
            boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }


    // Experience-only rule
    public static boolean isDraftable(
            int matchesPlayed) {

        return matchesPlayed >= 10;
    }


    // Matches + Fitness rule
    public static boolean isDraftable(
            int matchesPlayed,
            boolean injured) {

        return matchesPlayed >= 5 &&
                injured == false;
    }


    // Used by Arrays.sort()
    // Sort by batting average in descending order
    public int compareTo(Player other) {

        return Double.compare(
                other.battingAverage,
                this.battingAverage
        );
    }


    public String getName() {

        return name;
    }


    public static String draftAndRank(
            Player[] players) {

        int count = 0;

        // Count draftable players
        for (int i = 0;
             i < players.length;
             i++) {

            Player player = players[i];

            if (isDraftable(
                    player.matchesPlayed) ||

                isDraftable(
                    player.matchesPlayed,
                    player.injured)) {

                count++;
            }
        }


        // Create array for draftable players
        Player[] draftable =
                new Player[count];

        int index = 0;


        // Add draftable players
        for (int i = 0;
             i < players.length;
             i++) {

            Player player = players[i];

            if (isDraftable(
                    player.matchesPlayed) ||

                isDraftable(
                    player.matchesPlayed,
                    player.injured)) {

                draftable[index] = player;

                index++;
            }
        }


        // Sort using Arrays.sort()
        Arrays.sort(draftable);


        String result = "";


        // Create ranking
        for (int i = 0;
             i < draftable.length;
             i++) {

            result = result +
                    (i + 1) +
                    ". " +
                    draftable[i].getName();

            if (i != draftable.length - 1) {

                result = result + " | ";
            }
        }

        return result;
    }
}


public class FantasyLeagueAutoDraft {

    public static void main(String[] args) {

        Player[] players = {

                new Player(
                        "Virat",
                        15,
                        48.0,
                        false
                ),

                new Player(
                        "Rahul",
                        7,
                        55.0,
                        false
                ),

                new Player(
                        "Sameer",
                        3,
                        60.0,
                        false
                ),

                new Player(
                        "Dev",
                        12,
                        20.0,
                        true
                )
        };


        System.out.println(
                Player.draftAndRank(players)
        );
    }
}