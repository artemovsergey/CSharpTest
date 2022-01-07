package functions.logarithm;

import functions.Function;

public class LogarithmFunction extends Function {

    private final Ln ln;
    private final Log3 log3;
    private final Log5 log5;
    private final Log10 log10;

    public LogarithmFunction(Ln ln, Log3 log3, Log5 log5, Log10 log10) {
        super(ln.accuracy);
        this.ln = ln;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
        setFunctionName("Logarithmic function");
    }

    @Override
    public double calculateFunction(double x) {
        if (x == 1) {
            return Double.POSITIVE_INFINITY;
        }

        return  ((((Math.pow(log3.log3(x) / log5.log5(x),3)) / ((log3.log3(x) * ln.ln(x)) * log5.log5(x))) / log10.log10(x)) + log3.log3(x));
    }
}
