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
                System.out.println(e.getMessage() + " ** Please try again **");
            }

        }
        System.out.println("Loading...\n");

        Game game = new Game();
        System.out.println("Starting Bowling Game ");
        game.playGame(players[0], players[1]);

        input.close();
    }
}