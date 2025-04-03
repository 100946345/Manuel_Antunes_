import java.util.Scanner;

public class Game {

    private int frame = 1 ;
    private Player winner;

    public void playGame(Player player1, Player player2) {
        Scanner input = new Scanner(System.in);

        for (int game = 1; game <= 3; game++) {
            System.out.println("Starting Game " + game);
            player1.setScore(0);
            player2.setScore(0);

            for (frame = 1; frame <= 10; frame++) {
                System.out.println("Frame " + frame);
                //Enhanced for loop
                for (Player player : new Player[]{player1, player2}) {

                    boolean validTurn = false;
                    int firstRoll = 0;
                    int secondRoll = 0;
                    int bonus = 0;

                    while (!validTurn) {
                        try {
                            System.out.print(player.getName() + "'s, enter pins for first roll - ");
                            firstRoll = input.nextInt();
                            if (firstRoll < 0 || firstRoll > 10 ) {
                                throw new CustomValidationException("Invalid number of pins knocked down: " + firstRoll);
                            }

                            boolean isStrike = (firstRoll == 10);
                            int frameScore;

                            if (isStrike) {
                                System.out.println("*** STRIKE ***");
                                int bonusRoll1 = getBonusRoll(player.getName(), 1, input);
                                int bonusRoll2 = getBonusRoll(player.getName(), 2, input);
                                bonus = bonusRoll1 + bonusRoll2;
                                secondRoll = 0;

                                frameScore = firstRoll + bonus;
                            } else {
                                System.out.print(player.getName() + "'s, enter pins for second roll - ");
                                secondRoll = input.nextInt();
                                if (secondRoll < 0 || secondRoll > 10 || firstRoll + secondRoll > 10) {
                                    throw new CustomValidationException("Invalid number of total pins knocked down in a frame - "
                                            + (firstRoll + secondRoll));
                                }

                                if (firstRoll + secondRoll == 10) {
                                    System.out.println("*** SPARE ***");
                                    bonus = getBonusRoll(player.getName(), 1, input);
                                }

                                frameScore = firstRoll + secondRoll + bonus;
                            }

                            player.updateScore(frameScore);

                            System.out.println("Throw 1 - " + firstRoll + " || Throw 2 - " + secondRoll + " || Score - " + frameScore);
                            System.out.println();
                            validTurn = true;
                        } catch (CustomValidationException e) {
                            System.out.println(e.getMessage() + " Please try again.");
                        }
                    }
                }
            }

            System.out.println("Game " + game + " Results:");
            System.out.println(player1.getName() + " Final Score - " + player1.getScore());
            System.out.println(player2.getName() + " Final Score - " + player2.getScore());

            if (player1.getScore() > player2.getScore()) {
                System.out.println("Winner: " + player1.getName());
            } else if (player2.getScore() > player1.getScore()) {
                System.out.println("Winner: " + player2.getName());
            } else {
                System.out.println("Congrats to both of u, it's a tie");
            }
            System.out.println("_________________________________");
        }

        input.close();
    }

    static int getBonusRoll(String playerName, int bonusIndex, Scanner input) {
        int bonus = -1;

        while (bonus < 0 || bonus > 10) {
            try {
                System.out.print(playerName + ", enter score for bonus roll " + bonusIndex + "- ");
                if (!input.hasNextInt()) {
                    //ENTER
                    input.next();
                    throw new CustomValidationException("Invalid input! Please enter a number between 0 and 10.");
                }

                bonus = input.nextInt();

                if (bonus < 0 || bonus > 10) {
                    throw new CustomValidationException("Invalid number of pins knocked down: " + bonus);
                }
            } catch (CustomValidationException e) {
                System.out.println(e.getMessage() + " Please try again.");
            }
        }
        return bonus;
    }

    public String toString() {

        return "Current Frame: " + frame + ", Winner: " + (winner != null ? winner.getName() : "None");
    }
}
