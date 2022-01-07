package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class RoomTest {

    private Room room;

    @BeforeEach
    void setUp(){
        room = new Room("room",true, null);
    }

    @Test
    void testRoom() {
        Assertions.assertEquals("room", room.getName());
        Assertions.assertEquals(Arrays.asList(),room.getAeromobileList());

        Assertions.assertTrue(room.isHuge());
    }

    @Test
    void testAeromobileAdding() {
        Room room = new Room("room",true, null);
        Aeromobile aeromobile = new Aeromobile(1);
        room.addAeromobile(aeromobile);
        Assertions.assertEquals(Arrays.asList(aeromobile), room.getAeromobileList());
    }

    @Test
    void testAeromobileRemoving() {
        Aeromobile aeromobile = new Aeromobile(1);
        Room room = new Room("room",true, new ArrayList<>(Arrays.asList(aeromobile)));
        room.removeAeromobile(aeromobile);
        Assertions.assertEquals(Arrays.asList(), room.getAeromobileList());
    }

}
