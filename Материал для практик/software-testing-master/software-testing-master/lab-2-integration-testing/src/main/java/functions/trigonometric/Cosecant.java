package functions.trigonometric;

import functions.Function;

public class Cosecant extends Function {

    private final Sine sine;

    public Cosecant(Sine sine) {
        super(sine.accuracy);
        this.sine = sine;
        setFunctionName("Cosecant");
    }

    public double csc(double x) {
        return calculateFunction(x);
    }

    @Override
    public double calculateFunction(double x) {
        if (x == 0) {
            return Double.POSITIVE_INFINITY;
        }

        return 1 / sine.sin(x);
    }
}
