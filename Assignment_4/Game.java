import java.util.Scanner;

public class Game {

    private int frame;
    private Player winner;

    public Game() {
        this.frame = 1;
    }

    public void playGame(Player player1, Player player2) {
        Scanner scanner = new Scanner(System.in);

        for (frame = 1; frame <= 10; frame++) {
            System.out.println("Frame " + frame);
            for (Player player : new Player[]{player1, player2}) {

                boolean validTurn = false;
                int firstRoll = 0;
                int secondRoll = 0;
                int bonus = 0;

                while (!validTurn) {
                    try {
                        System.out.print(player.getName() + "'s, enter pins for first roll - ");
                        firstRoll = scanner.nextInt();
                        if (firstRoll < 0 || firstRoll > 10) {
                            throw new CustomValidationException("Invalid number of pins knocked down: " + firstRoll);
                        }

                        boolean isStrike = (firstRoll == 10);
                        if (isStrike) {
                            System.out.println("*** STRIKE ***");
                            int bonusRoll1 = getBonusRoll(player.getName(), 1, scanner);
                            int bonusRoll2 = getBonusRoll(player.getName(), 2, scanner);
                            bonus = bonusRoll1 + bonusRoll2;
                            secondRoll = 0;
                        } else {
                            System.out.print(player.getName() + "'s, enter pins for second roll - ");
                            secondRoll = scanner.nextInt();
                            if (secondRoll < 0 || secondRoll > 10 || firstRoll + secondRoll > 10) {
                                throw new CustomValidationException("Invalid number of total pins knocked down in a frame - "
                                        + (firstRoll + secondRoll));
                            }
                        }

                        if (!isStrike && firstRoll + secondRoll == 10) {
                            System.out.println("*** SPARE ***");
                            bonus = getBonusRoll(player.getName(), 1, scanner);
                        } else {
                            bonus = 0;
                        }

                        int frameScore = firstRoll + secondRoll + bonus;
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
        if (player1.getScore() > player2.getScore()) {
            winner = player1;
        } else if (player2.getScore() > player1.getScore()) {
            winner = player2;
        } else {
            System.out.println("It's a tie ");
            return;
        }
        System.out.println("Winner: " + winner.getName());
        scanner.close();
    }

    static int getBonusRoll(String playerName, int bonusIndex, Scanner scanner) {
        int bonus = 0;
        while (true) {
            try {
                System.out.print(playerName + ", enter score for bonus roll " + bonusIndex + ": ");
                bonus = scanner.nextInt();
                if (bonus < 0 || bonus > 10) {
                    throw new CustomValidationException("Invalid number of pins knocked down: " + bonus);
                }
                break;
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
