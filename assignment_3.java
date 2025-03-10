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

    static void getTurnScores(String player) {
        int firstRoll = getRoll();
        int bonus = 0;

        System.out.println(player + ", insert your first roll - ");
        if (firstRoll == 10) {
            System.out.print("*** STRIKE ***");
            for (int i = 0; i < 2; i++) {
                System.out.println(player + ", enter score for bonus roll " + (i + 1) + ":");
                bonus += getRoll();
            }
            return 10 + bonus;

        } else {
            System.out.println(player + ", insert your second roll - ");
            int secondRoll = getRoll();
            if (firstRoll + secondRoll == 10) {
                System.out.print("*** SPAARE ***");
                System.out.println(player + ", enter score for bonus roll:");
                bonus += getRoll();

                return 10 + bonus;

            } else {
                return firstRoll + secondRoll;
            }

        }

    }

    static int[] getGameScores(String player) {
        int [] playerScore = new int [10];
        for (int frame = 0; frame < 10; frame++) {
            playerScore[frame] = getTurnScores(player, );
        }
        return playerScore;
    }

}
