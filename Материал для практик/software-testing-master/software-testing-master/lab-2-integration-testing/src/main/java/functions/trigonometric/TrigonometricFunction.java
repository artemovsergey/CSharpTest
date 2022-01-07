package functions.trigonometric;

import functions.Function;

public class TrigonometricFunction extends Function {

    private final Sine sine;
    private final Cosine cosine;
    private final Tangent tangent;
    private final Cotangent cotangent;
    private final Secant secant;
    private final Cosecant cosecant;

    public TrigonometricFunction(Sine sine, Cosine cosine, Tangent tangent, Cotangent cotangent, Secant secant, Cosecant cosecant)
    {
        super(sine.accuracy);
        this.sine = sine;
        this.cosine = cosine;
        this.tangent = tangent;
        this.cotangent = cotangent;
        this.secant = secant;
        this.cosecant = cosecant;
        setFunctionName("Trigonometric function");
    }

    @Override
    public double calculateFunction(double x) {
        if (x < -Math.PI/2 || x > -1.2) {
            throw new IllegalArgumentException();
        }
        return (((Math.pow(((Math.pow((secant.sec(x) / sine.sin(x)) * cosecant.csc(x),3)) - (secant.sec(x) + (cotangent.cot(x) +
                (cosine.cos(x) + cosine.cos(x))))) * (Math.pow(cotangent.cot(x) - cosine.cos(x) + cotangent.cot(x), 3)), 2))
                + cotangent.cot(x))) * (cosine.cos(x) / (tangent.tan(x) + (sine.sin(x) / (cotangent.cot(x) *2)) * secant.sec(x)));
    }
}
