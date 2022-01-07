package model;

public class Infinity {

    private boolean isFlat;
    private boolean isInteresting;

    public Infinity(boolean isFlat, boolean isInteresting) {
        this.isFlat = isFlat;
        this.isInteresting = isInteresting;
    }

    public boolean isFlat() {
        return isFlat;
    }

    public boolean isInteresting() {
        return isInteresting;
    }

    public void setFlat(boolean flat) {
        isFlat = flat;
    }

    public void setInteresting(boolean interesting) {
        isInteresting = interesting;
    }
}
