public class Throw {

    private int pins;
    private boolean isStrike;
    private boolean isSpare;

    public Throw(int pins) {
        this.pins = pins;
        this.isStrike = (pins == 10);
    }

    public int getPins() {
        return pins;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public boolean isSpare() {
        return isSpare;

    }
}
