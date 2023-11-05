package home_work_2.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class SortTest {
    private int[] initArray = {-3, 7, 12, 1, -5, 10};
    private int[] sortedArray = {-5, -3, 1, 7, 10, 12};

    @Test
    @DisplayName("Bubble sort test")
    public void bubbleSort() {
        SortsUtils.sort(initArray);
        assertArrayEquals(sortedArray, initArray);
    }

    @Test
    @DisplayName("Bubble sort test")
    public void shakeSort() {
        SortsUtils.sort(initArray);
        assertArrayEquals(sortedArray, initArray);
    }

    @Test
    @DisplayName("Random array test")
    public void random() {
        int[] array = ArraysUtils.arrayRandom(10, 5);
        assertEquals(array.length, 10);

        boolean asExpected = true;
        for (int a : array)
            if (a >= 5) {
                asExpected = false;
                break;
            }
        assertTrue(asExpected);
    }
}
