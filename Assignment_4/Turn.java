public class Turn {

    private Throw throw_one;
    private Throw throw_two;
    private int score;

    public Turn(Throw throwOne, Throw throwTwo) {
        this.throw_one = throwOne;
        this.throw_two = throwTwo;
        this.score = throwOne.getPins() + throwTwo.getPins();
    }

    public int getScore() {
        return score;
    }

    public String toString() {

        return "Throw 1: " + throw_one.getPins() + ", Throw 2: " + throw_two.getPins() +
                ", Score: " + score;

    }
}

