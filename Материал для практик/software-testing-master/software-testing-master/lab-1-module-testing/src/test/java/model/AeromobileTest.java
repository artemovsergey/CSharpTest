package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AeromobileTest {

    private Aeromobile aeromobile;

    @BeforeEach
    void setUp() {
        aeromobile = new Aeromobile(1);
    }

    @Test
    void testAeromobile() {
        Assertions.assertEquals(1, aeromobile.getId());
    }

}
