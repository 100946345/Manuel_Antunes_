public class Turn {

    private Throw throw_one;
    private Throw throw_two;
    private int score;

    public Turn(Throw throwOne, Throw throwTwo) {
        this.throw_one = throwOne;
        this.throw_two = throwTwo;
        this.score = throwOne.getPins() + throwTwo.getPins();

        if (throwOne.isStrike()) {
            score += 10;
        } else if (score == 10) {
            score += 5;
        }

    }

    public int getScore() {
        return score;
    }

    public String toString() {

        return "Throw 1: " + throw_one.getPins() + ", Throw 2: " + throw_two.getPins() +
                ", Score: " + score;

    }
}

