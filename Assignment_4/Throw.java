public class Throw {

    private int pins;
    private boolean isStrike;
    private boolean isSpare;

    public Throw(int pins) throws CustomValidationException{

        if (pins < 0 || pins > 10) {
            throw new CustomValidationException("Invalid number of pins knocked down: " + pins);
        }
        this.pins = pins;
        this.isStrike = (pins == 10);
        this.isSpare = false;
    }

    public int getPins() {
        return pins;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public boolean isSpare() { return isSpare; }

    public void setSpare(boolean spare) {
        this.isSpare = spare;
    }

}
