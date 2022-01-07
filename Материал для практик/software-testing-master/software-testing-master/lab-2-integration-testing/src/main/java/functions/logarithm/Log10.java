package functions.logarithm;

import functions.Function;

public class Log10 extends Function {

    private final Ln ln;

    public Log10(Ln ln) {
        super(ln.accuracy);
        this.ln = ln;
        setFunctionName("Log10");
    }

    public double log10(double x) {
        return calculateFunction(x);
    }

    @Override
    public double calculateFunction(double x) {
        return ln.ln(x) / ln.ln(10);
    }
}
