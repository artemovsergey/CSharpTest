package functions.trigonometric;

import functions.Function;

public class Cosine extends Function {

    private final Sine sine;

    public Cosine(Sine sine) {
        super(sine.accuracy);
        this.sine = sine;
        setFunctionName("Cosine");
    }

    public double cos(double x) {
        return calculateFunction(x);
    }

    @Override
    public double calculateFunction(double x) {

        while (x > 2 * Math.PI) {
            x -= 2 * Math.PI;
        }

        while (x < 0) {
            x += 2 * Math.PI;
        }

        if (x > Math.PI/2 && x < 3*Math.PI/2) {
            return -Math.sqrt(1 - Math.pow(sine.sin(x),2));
        } else {
            return Math.sqrt(1 - Math.pow(sine.sin(x),2));
        }
    }
}
