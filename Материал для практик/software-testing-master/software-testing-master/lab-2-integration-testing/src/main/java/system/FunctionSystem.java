package system;

import functions.Function;
import functions.logarithm.LogarithmFunction;
import functions.trigonometric.TrigonometricFunction;

public class FunctionSystem extends Function {

    private final TrigonometricFunction trigonometricFunction;
    private final LogarithmFunction logarithmFunction;

    public FunctionSystem(TrigonometricFunction trigonometricFunction, LogarithmFunction logarithmFunction) {
        super(trigonometricFunction.accuracy);
        this.trigonometricFunction = trigonometricFunction;
        this.logarithmFunction = logarithmFunction;
        setFunctionName("System");
    }

    @Override
    public double calculateFunction(double x) {
        return x <= 0 ? trigonometricFunction.calculateFunction(x) : logarithmFunction.calculateFunction(x);
    }
}
