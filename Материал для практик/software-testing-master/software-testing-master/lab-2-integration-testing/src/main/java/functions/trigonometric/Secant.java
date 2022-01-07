package functions.trigonometric;

import functions.Function;

public class Secant extends Function {

    private final Cosine cosine;

    public Secant(Cosine cosine) {
        super(cosine.accuracy);
        this.cosine = cosine;
        setFunctionName("Secant");
    }

    public double sec(double x) {
        return calculateFunction(x);
    }

    @Override
    public double calculateFunction(double x)
    {
        if (x == Math.PI / 2) {
            return Double.POSITIVE_INFINITY;
        }

        return 1 / cosine.cos(x);
    }
}
