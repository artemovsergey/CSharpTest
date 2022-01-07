package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InfinityTest {

    @Test
    void testInfinity() {
        Infinity infinity = new Infinity(true, true);

        Assertions.assertTrue(infinity.isFlat());
        Assertions.assertTrue(infinity.isInteresting());

        infinity.setFlat(false);
        infinity.setInteresting(false);

        Assertions.assertFalse(infinity.isFlat());
        Assertions.assertFalse(infinity.isInteresting());
    }

}
