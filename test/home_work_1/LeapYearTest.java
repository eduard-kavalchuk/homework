package home_work_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LeapYearTest {
    @Test
    @DisplayName("Leap year")
    public void leapYear() {
        assertTrue(LeapYear.isLeapYear(1980));
    }

    @Test
    @DisplayName("Not a leap year")
    public void notLeapYear() {
        assertFalse(LeapYear.isLeapYear(1981));
    }
}
