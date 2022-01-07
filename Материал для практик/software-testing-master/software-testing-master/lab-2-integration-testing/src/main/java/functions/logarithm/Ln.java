package functions.logarithm;

import functions.Function;

public class Ln extends Function {

    public Ln(double accuracy) {
        super(accuracy);
        setFunctionName("Ln");
    }

    public double ln(double x) {
        return calculateFunction(x);
    }

    @Override
    public double calculateFunction(double x) {
        int countN = 300;

        if (x < 0) {
            throw new IllegalArgumentException();
        }

        if (x > 1) {
            return -calculateFunction(1/x);
        }

        if (x == 0) {
            return Double.NEGATIVE_INFINITY;
        }

        if (x == 1) {
            return 0;
        }

        double sum = 0;
        double prevSum = -10;

        for (int i = 1; i < countN && Math.abs(prevSum - sum) > accuracy; i++) {
            prevSum = sum;
            sum += Math.pow(-1, i-1) * Math.pow(x - 1, i) / i;
        }

        return sum;
    }
}
