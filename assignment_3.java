/*   Name: Manuel Antunes
     Date: 2025-03-09
     Description: This program calculates the results of a bowling
     game based on the user's input, displays the game score, and
     asks if the user wants to play again.

 */

import java.util.Scanner;

public class assignment_3 {
    static Scanner input = new Scanner(System.in);

    static final int FRAMES = 10;
    static final int PINS = 10;

    public static void main(String[] args) {

        boolean playing;
        do {
            System.out.println("[Insert the name of each player]");
            System.out.print("Player (1) - ");
            String player_1 = input.nextLine();
            System.out.print("Player (2) - ");
            String player_2 = input.nextLine();
            System.out.print("Player (3) - ");
            String player_3 = input.nextLine();


            int[] player1_score = getGameScores(player_1);
            int[] player2_score = getGameScores(player_2);
            int[] player3_score = getGameScores(player_3);

            displayScores(player_1, player1_score);
            displayScores(player_2, player2_score);
            displayScores(player_3, player3_score);

            String winner = finalWiner(player_1, player1_score, player_2, player2_score, player_3, player3_score);
            System.out.println("\nWinner: " + winner);

            System.out.print("Ready to start another game? [yes or no] - ");
            playing = input.nextLine().equalsIgnoreCase("yes");
        } while (playing);


        input.close();
    }

    static int getRoll() {
        int roll = input.nextInt();
        while (roll < 0 || roll > 10) {
            System.out.println("Try again by entering a score between 0 and 10 - ");

            roll = input.nextInt();
        }
        input.nextLine();
        return roll;
    }

    static int getTurnScores(String player, int[] scores, int frame) {
        System.out.print(player + ", insert your first roll: ");
        int firstRoll = getRoll();
        int bonus = 0;
        boolean isStrike = (firstRoll == 10);

        if (isStrike) {
            System.out.println("*** STRIKE ***");
            bonus = getBonusScores(player, 2);
        } else {
            System.out.print(player + ", insert your second roll: ");
            int secondRoll = getRoll();
            if (firstRoll + secondRoll == 10) {
                System.out.println("*** SPARE ***");
                bonus = getBonusScores(player, 1);
            } else {
                bonus = secondRoll;
            }
        }

        scores[frame] = firstRoll + bonus;

        if (frame == FRAMES - 1 && (isStrike || firstRoll + bonus == 10)) {
            scores[frame] += (isStrike ? getBonusScores(player, 2) : getBonusScores(player, 1));
        }

        return scores[frame];
    }

    static int getBonusScores(String player, int rolls) {
        int bonus = 0;
        for (int i = 0; i < rolls; i++) {
            System.out.print(player + ", enter score for bonus roll " + (i + 1) + ": ");
            bonus += getRoll();
        }
        return bonus;
    }


    static int[] getGameScores(String player) {
        int[] scores = new int[FRAMES];
        int[] rolls = new int[21];
        int rollIndex = 0;

        for (int frame = 0; frame < FRAMES; frame++) {
            System.out.println("\nFrame " + (frame + 1) + " for " + player);
            rolls[rollIndex++] = getTurnScores(player, scores, frame);
        }
        return scores;
    }


    static void displayScores(String player, int[] scores) {
        System.out.println("\nScores for " + player + ":");
        System.out.println("Frame\tScore");
        int cumulativeScore = 0;
        for (int i = 0; i < scores.length; i++) {
            cumulativeScore += scores[i];
            System.out.println((i + 1) + "\t" + cumulativeScore);
        }
    }

    static String finalWiner(String player1, int[] scores1, String player2, int[] scores2, String player3, int[] scores3) {
        int score1 = totalScore(scores1);
        int score2 = totalScore(scores2);
        int score3 = totalScore(scores3);

        if (score1 >= score2 && score1 >= score3) {
            return player1;
        } else if (score2 >= score1 && score2 >= score3) {
            return player2;
        } else {return player3;
        }
    }

    static int totalScore(int[] scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }
}
