package functions;

public abstract class Function {

    public final double accuracy;
    private String functionName;

    public Function(double accuracy) {
        this.accuracy = accuracy;
    }

    abstract public double calculateFunction(double x);

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    @Override
    public String toString() {
        return functionName;
    }
}
