public class FunctionCalculator {
    
    // x - x^3/3 + x^5/5 - x^7/7 + ... + (-1)^(n-1)*x^(2n-1)/(2n-1) - ...
    public double calculateArctangent(double x) {

        if (Math.abs(x) > 1) {
            throw new IllegalArgumentException("|X| must be <= 1");
        }

        int countN = 140;
        double sum = 0;

        for (int i = 1; i < countN; i++) {
            sum += Math.pow(-1, i-1) * Math.pow(x, 2*i - 1) / (2 * i - 1);
        }

        return sum;
    }

}
