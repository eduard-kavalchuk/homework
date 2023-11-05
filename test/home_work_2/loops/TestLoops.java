package home_work_2.loops;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class TestLoops {
    @Test
    @DisplayName("Bubble sort test")
    public void printFactorUsingLoops() {
        String result = "1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 = 479001600";
        assertEquals(result, Task1_1.useLoops(12));
    }

    @Test
    @DisplayName("Bubble sort test")
    public void printFactorUsingRecursion() {
        String result = "1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 = 479001600";
        assertEquals(result, Task1_1.useRecursion(12));
    }

    @Test
    @DisplayName("Calculate test")
    public void calculate() {
        String expected = "4 * 7 * 1 * 6 = 42";
        String actual = Task1_2.calculate("4716");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Power test")
    public void power() {
        double expected = 39.0625;
        double actual = Task1_3.power(2.5, 4);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Fibonacci test")
    public void fibonacci() {
        String expected = "0 1 1 2 3 5 8 13 21 34 55";
        String actual = Task1_5.fibonacci(10);
        assertEquals(expected, actual);
    }
}
