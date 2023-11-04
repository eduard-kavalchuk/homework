package home_work_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BytesToKbTest {
    private static final int BYTES_IN_KB = 1024;
    @Test
    @DisplayName("Phone number")
    public void kBytes() {
        float expected = (float ) 2.5;
        float actual = BytesToKb.Bytes2Kb((int ) (expected * BYTES_IN_KB));
        assertEquals(expected, actual);
    }
}
