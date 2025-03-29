public class Turn {

    private Throw throw_one;
    private Throw throw_two;
    private int score;

    public Turn(Throw throwOne, Throw throwTwo) {
        this.throwOne = throwOne;
        this.throwTwo = throwTwo;
        this.score = throwOne.getPins() + throwTwo.getPins();
    }


    public String toString() {

        return "";
    }
}
