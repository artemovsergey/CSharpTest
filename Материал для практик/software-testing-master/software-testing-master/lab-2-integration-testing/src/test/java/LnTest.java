import functions.logarithm.Ln;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class LnTest {

    private static Ln ln;
    private static final double DELTA = 0.0001;
    private static final double accuracy = 0.00000001;

    @BeforeAll
    public static void setUp() {
        ln = new Ln(accuracy);
    }

    @ParameterizedTest
    @MethodSource("provideDoubleValues")
    public void testLn(double expected, double value) {
        Assertions.assertEquals(expected, ln.ln(value), DELTA);
    }

    @Test
    public void testNegativeValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ln.ln(-10));
    }

    private static Stream<Arguments> provideDoubleValues() {
        return Stream.of(
                Arguments.of(Double.NEGATIVE_INFINITY, 0),
                Arguments.of(-0.693147, 0.5),
                Arguments.of(2.30258509299, 10),
                Arguments.of(0, 1)
        );
    }

}
