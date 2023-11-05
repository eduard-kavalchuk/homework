package home_work_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryStringTest {
    @Test
    @DisplayName("Average")
    public void unsigned() {
        byte arg = (byte) 2;
        assertEquals("0b00000010", BinaryString.toBinaryString(arg));
    }

    @Test
    @DisplayName("Average")
    public void signed() {
        byte arg = (byte) -2;
        assertEquals("0b11111110", BinaryString.toBinaryString(arg));
    }
}
