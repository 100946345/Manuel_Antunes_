/*   Name: Manuel Antunes
     Date: 2025-03-29
     Description: This program calculates the results of a bowling
     game and declares the winner for each game. It supports multiple
     games and results are showing after each game.

 */

import java.util.Scanner;

public class Assignment_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Player[] players = new Player[2];
        int currentPlayer = 0;

        while (currentPlayer < 2) {
            try {
                System.out.print("Enter name for player " + (currentPlayer + 1) + " - ");
                String name = input.nextLine();
                players[currentPlayer] = new Player(name);
                currentPlayer++;
            } catch (CustomValidationException e) {
                System.out.println(e.getMessage() + " Please try again.");
            }

            for (int gameNumber = 1; gameNumber <= 3; gameNumber++) {
                System.out.println("\nStarting Game " + gameNumber + "!");
                Game game = new Game();

                while (!game.isComplete()) { // Implement this method in Game class
                    for (Player player : players) {
                        System.out.println("Current frame: " + game.getFrame());
                        System.out.println(player.getName() + "'s turn!");

                        System.out.print("Enter score for " + player.getName() + ": ");
                        int score = input.nextInt();

                        game.playTurn(player, score);
                    }
                }

                Player winner = game.getWinner(); // Define logic in Game class
                System.out.println("\nGame " + gameNumber + " Winner: " + (winner != null ? winner.getName() : "No one!"));
                if (winner != null) {
                    winner.setWins(winner.getWins() + 1);
                }
            }

            System.out.println("\nFinal Results:");
            for (Player player : players) {
                System.out.println(player);
            }

        input.close();
    }
}