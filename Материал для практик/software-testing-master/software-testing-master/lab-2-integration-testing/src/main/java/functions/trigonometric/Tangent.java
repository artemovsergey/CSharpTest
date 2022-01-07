package functions.trigonometric;

import functions.Function;

public class Tangent extends Function {

    Sine sine;
    Cosine cosine;

    public Tangent(Sine sine, Cosine cosine) {
        super(sine.accuracy);
        this.sine = sine;
        this.cosine = cosine;
        setFunctionName("Tangent");
    }

    public double tan(double x){
        return calculateFunction(x);
    }

    @Override
    public double calculateFunction(double x) {
        return sine.sin(x) / cosine.cos(x);
    }
}
