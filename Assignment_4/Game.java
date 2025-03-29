public class Game {

    private int frame = 1;
    private Player winner;

    public void playTurn(Player player, int score) {

        player.setScore(player.getScore() + score);
        frame++;
    }

    public int getFrame() {
        return frame;
    }

    public boolean isComplete() {
        return frame > 10;
    }

    public Player getWinner() {
        return winner;
    }


    public String toString() {

        return "Current Frame: " + frame + ", Winner: " + (winner != null ? winner.getName() : "TBD");
    }
}
