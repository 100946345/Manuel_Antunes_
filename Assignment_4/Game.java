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
                int roll1 = 0;
                int roll2 = 0;
                while (!validTurn) {
                    try {
                        if (roll1 == 0) {
                            System.out.print(player.getName() + "'s, enter pins for first roll - ");
                            roll1 = scanner.nextInt();
                            if (roll1 < 0 || roll1 > 10) {
                                throw new CustomValidationException("Invalid number of pins knocked down: " + roll1);
                            }
                        }

                        System.out.print(player.getName() + "'s, enter pins for second roll - ");
                        roll2 = scanner.nextInt();
                        if (roll2 < 0 || roll2 > 10) {
                            throw new CustomValidationException("Invalid number of pins knocked down: " + roll2);
                        }

                        if (roll1 + roll2 > 10) {
                            throw new CustomValidationException("Invalid number of total pins knocked down in a frame: " +
                                    (roll1 + roll2));
                        }

                        Turn turn = new Turn(roll1, roll2);
                        player.updateScore(turn.getScore());
                        System.out.println(turn);
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
            return;}
        System.out.println("Winner: " + winner.getName());
        scanner.close();

    }

    public String toString() {

        return "Current Frame: " + frame + ", Winner: " + (winner != null ? winner.getName() : "None");
    }
}
