package functions.trigonometric;

import functions.Function;

public class Sine extends Function {

    public Sine(double accuracy) {
        super(accuracy);
        setFunctionName("Sine");
    }

    public double sin(double x) {
        return calculateFunction(x);
    }

    @Override
    public double calculateFunction(double x) {

        while (x > Math.PI) {
            x -= 2 * Math.PI;
        }

        while (x < -Math.PI) {
            x += 2 * Math.PI;
        }

        int countN = 7;
        double sum = 0;
        double prevSum = -10;

        for (int i = 1; i < countN && Math.abs(sum - prevSum) > accuracy; i++) {
            prevSum = sum;
            sum += Math.pow(-1, i-1) * Math.pow(x, 2*i - 1) / calculateFactorial(2 * i - 1);
        }

        return sum;
    }

    private int calculateFactorial(int k) {
        if (k > 13) {
            throw new IllegalArgumentException("k must be lower than 13");
        }

        int fact = 1;

        for (int i = 1; i <= k; i++) {
            fact *= i;
        }

        return fact;
    }
}
