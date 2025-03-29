public class Turn {

    private Throw throw_one;
    private Throw throw_two;
    private int score;

    public Turn(int throwOnePins, int throwTwoPins) throws CustomValidationException {
        this.throw_one = new Throw(throwOnePins);
        this.throw_two = new Throw(throwTwoPins);
        calculateFrameScore();
    }

    private void calculateFrameScore() {
        score = throw_one.getPins() + throw_two.getPins();

        if (throw_one.isStrike()) {
            score = throw_one.getPins();
        } else if (throw_one.getPins() + throw_two.getPins() == 10) {
            throw_two.setSpare(true);
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

