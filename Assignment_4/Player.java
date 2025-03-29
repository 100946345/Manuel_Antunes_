public class Player {

    private String name;
    private int wins;
    private int score;

    public Player(String name) throws CustomValidationException{
        if (name == null || name.isEmpty()) {
            throw new CustomValidationException("Player name cannot be empty.");
        }

        this.name = name;
        this.wins = 0;
        this.score = 501;
    }


    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getScore() {
        return score;
    }


    public void incrementWins() {
        this.wins++;
    }

    public void updateScore(int pins) {
        if (pins < 0) {
            throw new IllegalArgumentException("Pins knocked down cannot be negative.");
        }
        this.score += pins;
    }

    public String toString(){
        return "                \n[Player]\n" +
                "                Name - " + name + "\n" +
                "                Wins - " + wins + "\n" +
                "                Score - " + score+"\n";

    }

}


