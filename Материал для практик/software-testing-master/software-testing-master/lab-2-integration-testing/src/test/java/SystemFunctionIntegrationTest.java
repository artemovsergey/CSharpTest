import functions.logarithm.LogarithmFunction;
import functions.trigonometric.TrigonometricFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import system.FunctionSystem;

import java.util.stream.Stream;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.when;

public class SystemFunctionIntegrationTest {

    private static FunctionSystem functionSystem;
    private final double DELTA = 0.00001;

    @BeforeAll
    static void setUp() {
        TrigonometricFunction trigonometricFunction = Mockito.mock(TrigonometricFunction.class);
        LogarithmFunction logarithmFunction = Mockito.mock(LogarithmFunction.class);
        functionSystem = new FunctionSystem(trigonometricFunction, logarithmFunction);

        when(trigonometricFunction.calculateFunction(-1.57)).thenReturn(0d);
        when(trigonometricFunction.calculateFunction(-1.22)).thenReturn(567.672);
        when(trigonometricFunction.calculateFunction(-1.2)).thenReturn(906.311);
        when(trigonometricFunction.calculateFunction(-1.5567)).thenReturn(0.0042);
        when(trigonometricFunction.calculateFunction(0)).thenThrow(new IllegalArgumentException());

        when(logarithmFunction.calculateFunction(1)).thenReturn(Double.POSITIVE_INFINITY);
        when(logarithmFunction.calculateFunction(0.6)).thenReturn(187.524);
        when(logarithmFunction.calculateFunction(0.2)).thenReturn(0.4428);
        when(logarithmFunction.calculateFunction(10)).thenReturn(2.551);
    }

    @ParameterizedTest
    @MethodSource("provideBoundaryDoubleValues")
    public void testBoundarySystemFunction(double expected, double value) {
        Assertions.assertEquals(expected, functionSystem.calculateFunction(value), DELTA);
    }

    @ParameterizedTest
    @MethodSource("provideDoubleValues")
    public void testSystemFunction(double expected, double value) {
        Assertions.assertEquals(expected, functionSystem.calculateFunction(value), DELTA);
    }

    @Test
    public void testZeroArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> functionSystem.calculateFunction(0));
    }

    private static Stream<Arguments> provideBoundaryDoubleValues() {
        return Stream.of(
                Arguments.of(0, -1.57),
                Arguments.of(906.311,-1.2),
                Arguments.of(Double.POSITIVE_INFINITY, 1)
        );
    }

    private static Stream<Arguments> provideDoubleValues() {
        return Stream.of(
                Arguments.of(2.551, 10),
                Arguments.of(0.4428, 0.2),
                Arguments.of(187.524, 0.6),
                Arguments.of(567.672, -1.22),
                Arguments.of(0.0042, -1.5567)
        );
    }

}
