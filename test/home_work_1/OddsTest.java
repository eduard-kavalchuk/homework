package home_work_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OddsTest {
    @Test
    @DisplayName("Test for odd number")
    public void odd() {
        assertTrue(FindOdd.isOdd(3));
    }

    @Test
    @DisplayName("Test for odd number")
    public void even() {
        assertFalse(FindOdd.isOdd(4));
    }
}
