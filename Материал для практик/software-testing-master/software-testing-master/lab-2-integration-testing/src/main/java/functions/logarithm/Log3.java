package functions.logarithm;

import functions.Function;

public class Log3 extends Function {

    private final Ln ln;

    public Log3(Ln ln) {
        super(ln.accuracy);
        this.ln = ln;
        setFunctionName("Log3");
    }

    public double log3(double x) {
        return calculateFunction(x);
    }

    @Override
    public double calculateFunction(double x) {


        return ln.ln(x) / ln.ln(3);
    }
}
