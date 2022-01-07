import functions.trigonometric.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.mockito.Mockito.when;

public class TrigonometricFunctionIntegrationTest {

    private static Sine sine;
    private static Cosine cosine;
    private static Tangent tangent;
    private static Cotangent cotangent;
    private static Secant secant;
    private static Cosecant cosecant;
    private static TrigonometricFunction trigonometricFunction;
    private final double DELTA = 0.0001;

    @BeforeAll
    static void setUp() {
        sine = Mockito.mock(Sine.class);
        cosine = Mockito.mock(Cosine.class);
        tangent = Mockito.mock(Tangent.class);
        cotangent = Mockito.mock(Cotangent.class);
        secant = Mockito.mock(Secant.class);
        cosecant = Mockito.mock(Cosecant.class);

        trigonometricFunction = new TrigonometricFunction(sine, cosine, tangent, cotangent, secant, cosecant);

        when(sine.sin(-1.57)).thenReturn(-0.999999683);
        when(cosine.cos(-1.57)).thenReturn(0.0007963);
        when(tangent.tan(-1.57)).thenReturn(-1255.77);
        when(cotangent.cot(-1.57)).thenReturn(-0.0007963);
        when(secant.sec(-1.57)).thenReturn(1255.77);
        when(cosecant.csc(-1.57)).thenReturn(-1.00000032);

        when(sine.sin(-1.4)).thenReturn(-0.9854497);
        when(cosine.cos(-1.4)).thenReturn(0.169967);
        when(tangent.tan(-1.4)).thenReturn(-5.79788);
        when(cotangent.cot(-1.4)).thenReturn(-0.172477);
        when(secant.sec(-1.4)).thenReturn(5.88349);
        when(cosecant.csc(-1.4)).thenReturn(-1.014765);

        when(sine.sin(-1.5)).thenReturn(-0.9974950);
        when(cosine.cos(-1.5)).thenReturn(0.0707372);
        when(tangent.tan(-1.5)).thenReturn(-14.1014);
        when(cotangent.cot(-1.5)).thenReturn(-0.0709148);
        when(secant.sec(-1.5)).thenReturn(14.1368);
        when(cosecant.csc(-1.5)).thenReturn(-1.002511);
    }

    @ParameterizedTest
    @MethodSource("provideDoubleValues")
    public void testTrigonometricFunction(double expected, double value) {
        Assertions.assertEquals(expected, trigonometricFunction.calculateFunction(value), DELTA);
    }

    private static Stream<Arguments> provideDoubleValues() {
        return Stream.of(
                Arguments.of(0, -1.57),
                Arguments.of(13.464, -1.4),
                Arguments.of(0.622848, -1.5)
        );
    }

}
