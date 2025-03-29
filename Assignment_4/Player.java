public class Player {

    private String name;
    private int wins = 0;
    private int score = 0;


    public Player(String name) throws CustomValidationException {
        if (name.trim().isEmpty() || name.matches(".*[!@#$%^&*/|?\\\\<>=\'\"].*")) {
            throw new IllegalArgumentException("The name can't be empty or contain inappropriate words.");
        }
        this.name = name;

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


    public  void setWins(int wins){
        if (wins<0){
            throw new IllegalArgumentException ("Wins can't be negative");
        }this.wins = wins;
    }

    public  void setScore(int score){
        if (score<0){
            throw new IllegalArgumentException ("The score can't be negative");
        }this.score = score;
    }

    public String toString(){
        return "                \n[Player]\n" +
                "                Name - " + name + "\n" +
                "                Wins - " + wins + "\n" +
                "                Score - " + score+"\n";

    }

}


