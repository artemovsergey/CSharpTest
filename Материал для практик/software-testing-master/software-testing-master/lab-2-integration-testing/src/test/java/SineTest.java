import functions.trigonometric.Sine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SineTest {

    private static Sine sine;
    private final static double DELTA = 0.001;
    private final static double accuracy = 0.00001;

    @BeforeAll
    public static void setUp() {
        sine = new Sine(accuracy);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2*Math.PI, -Math.PI, -Math.PI/2, -Math.PI/4, 0, -3 * Math.PI/2})
    public void testSine(double value) {
        Assertions.assertEquals(Math.sin(value), sine.sin(value), DELTA);
    }

}
