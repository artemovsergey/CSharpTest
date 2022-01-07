package functions.trigonometric;

import functions.Function;

public class Cotangent extends Function {

    private final Sine sine;
    private final Cosine cosine;

    public Cotangent(Sine sine, Cosine cosine) {
        super(sine.accuracy);
        this.sine = sine;
        this.cosine = cosine;
        setFunctionName("Cotangent");
    }


    public double cot(double x) {
        return calculateFunction(x);
    }

    @Override
    public double calculateFunction(double x) {
        return cosine.cos(x) / sine.sin(x);
    }
}
