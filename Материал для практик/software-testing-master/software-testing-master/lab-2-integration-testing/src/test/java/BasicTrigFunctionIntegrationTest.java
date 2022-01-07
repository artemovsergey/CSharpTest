import functions.trigonometric.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.when;

public class BasicTrigFunctionIntegrationTest {

    private final double DELTA = 0.0001;

    @ParameterizedTest
    @ValueSource(doubles = {0, -2*Math.PI, -Math.PI, -Math.PI/4})
    public void testCosineIntegration(double value) {
        Sine sine = Mockito.mock(Sine.class);
        when(sine.sin(anyDouble())).thenReturn(Math.sin(value));

        Cosine cosine = new Cosine(sine);

        Assertions.assertEquals(Math.cos(value), cosine.cos(value), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI/4, Math.PI/2, Math.PI, -Math.PI/2, -Math.PI, -Math.PI/4})
    public void testSecantIntegration(double value) {
        Cosine cosine = Mockito.mock(Cosine.class);
        when(cosine.cos(anyDouble())).thenReturn(Math.cos(value));

        Secant secant = new Secant(cosine);

        if (value == Math.PI/2) {
            Assertions.assertEquals(Double.POSITIVE_INFINITY, secant.sec(value), DELTA);
        } else {
            Assertions.assertEquals(1 / Math.cos(value), secant.sec(value), DELTA);
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI/4, Math.PI/2, Math.PI, -Math.PI/2, -Math.PI, -Math.PI/4})
    public void testCosecantIntegration(double value) {
        Sine sine = Mockito.mock(Sine.class);
        when(sine.sin(anyDouble())).thenReturn(Math.sin(value));

        Cosecant cosecant = new Cosecant(sine);
        Assertions.assertEquals(1 / Math.sin(value), cosecant.csc(value), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI/4, Math.PI/2, Math.PI, -Math.PI/2, -Math.PI, -Math.PI/4})
    public void testTangentIntegration(double value) {
        Sine sine = Mockito.mock(Sine.class);
        Cosine cosine = Mockito.mock(Cosine.class);

        when(sine.sin(anyDouble())).thenReturn(Math.sin(value));
        when(cosine.cos(anyDouble())).thenReturn(Math.cos(value));

        Tangent tangent = new Tangent(sine, cosine);
        Assertions.assertEquals(Math.tan(value), tangent.tan(value), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI/4, Math.PI/2, Math.PI, -Math.PI/2, -Math.PI, -Math.PI/4})
    public void testCotangentIntegration(double value) {
        Sine sine = Mockito.mock(Sine.class);
        Cosine cosine = Mockito.mock(Cosine.class);

        when(sine.sin(anyDouble())).thenReturn(Math.sin(value));
        when(cosine.cos(anyDouble())).thenReturn(Math.cos(value));

        Cotangent cotangent = new Cotangent(sine, cosine);
        Assertions.assertEquals(1 / Math.tan(value), cotangent.cot(value), DELTA);
    }




}
