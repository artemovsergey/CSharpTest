package functions.logarithm;

import functions.Function;

public class Log5 extends Function {

    private final Ln ln;

    public Log5(Ln ln) {
        super(ln.accuracy);
        this.ln = ln;
        setFunctionName("Log5");
    }

    public double log5(double x) {
        return calculateFunction(x);
    }

    @Override
    public double calculateFunction(double x) {
        return ln.ln(x) / ln.ln(5);
    }
}
