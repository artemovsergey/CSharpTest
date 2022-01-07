import functions.logarithm.*;
import functions.trigonometric.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.mockito.Mockito.when;

public class LogarithmFunctionIntegrationTest {

    private static Ln ln;
    private static Log3 log3;
    private static Log5 log5;
    private static Log10 log10;
    private static LogarithmFunction logarithmFunction;
    private final double DELTA = 0.0001;

    @BeforeAll
    static void setUp() {
        ln = Mockito.mock(Ln.class);
        log3 = Mockito.mock(Log3.class);
        log5 = Mockito.mock(Log5.class);
        log10 = Mockito.mock(Log10.class);

        logarithmFunction = new LogarithmFunction(ln, log3, log5, log10);

        when(ln.ln(-1)).thenThrow(new IllegalArgumentException());

        when(ln.ln(10)).thenReturn(2.302585092);
        when(log3.log3(10)).thenReturn(2.095903274);
        when(log5.log5(10)).thenReturn(1.430676558);
        when(log10.log10(10)).thenReturn(1d);

        when(ln.ln(0.6)).thenReturn(-0.510826);
        when(log3.log3(0.6)).thenReturn(-0.464974);
        when(log5.log5(0.6)).thenReturn(-0.317394);
        when(log10.log10(0.6)).thenReturn(-0.221849);

        when(ln.ln(0.4)).thenReturn(-0.916291);
        when(log3.log3(0.4)).thenReturn(-0.834044);
        when(log5.log5(0.4)).thenReturn(-0.569323);
        when(log10.log10(0.4)).thenReturn(-0.397940);
    }

    @ParameterizedTest
    @MethodSource("provideDoubleValues")
    public void testLogarithmFunction(double expected, double value) {
        Assertions.assertEquals(expected, logarithmFunction.calculateFunction(value), DELTA);
    }

    private static Stream<Arguments> provideDoubleValues() {
        return Stream.of(
                Arguments.of(2.5512, 10),
                Arguments.of(187.5238, 0.6),
                Arguments.of(17.3249, 0.4)
        );
    }

    @Test
    public void testNegativeLogarithmFunction() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> logarithmFunction.calculateFunction(-1));
    }

}
