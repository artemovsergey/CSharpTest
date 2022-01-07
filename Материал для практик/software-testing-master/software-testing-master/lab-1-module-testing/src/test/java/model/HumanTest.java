package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HumanTest {

    @Test
    void testHuman() {
        Human human = new Human("Коля");

        Assertions.assertEquals("Коля", human.getName());
        Assertions.assertEquals("вы видите бесконечность: расстояние необъемлемо и оттого бессмысленно", human.lookIntoTheSky());
    }

}
