package home_work_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestForAverage {
    @Test
    @DisplayName("Average")
    public void symbol() {
        int[] array = {10, -8, -5, 14, 0, -7};
        assertEquals(-7, AvgOfThree.GetAvg(array));
    }
}
