import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertionSortTest {

    static InsertionSort insertionSort;
    static List<Integer> listStart = Arrays.asList(353, 104, 189, 950, 610, 196,  46, 469, 896, 349, 816, 526, 876, 151, 555, 984, 454, 162, 959, 712);
    static List<Integer> sortedList = new ArrayList<>();
    static List<Integer> expectedList = Arrays.asList(46, 104, 151, 162, 189, 196, 349, 353, 454, 469, 526, 555, 610, 712, 816, 876, 896, 950, 959, 984);


    @BeforeAll
    static void setUp() {
        insertionSort = new InsertionSort();
        sortedList.addAll(listStart);
        insertionSort.sortList(sortedList);
    }

    @Test
    public void testManualInsertionSort() {
        Assertions.assertArrayEquals(expectedList.toArray(), sortedList.toArray());
    }

    @Test
    public void testAutoInsertionSort() {
        List<Integer> copyStartList = new ArrayList<>(listStart);
        Collections.sort(copyStartList);
        Assertions.assertArrayEquals(copyStartList.toArray(), sortedList.toArray());
    }



}
