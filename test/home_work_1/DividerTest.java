package home_work_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DividerTest {
    @Test
    @DisplayName("Divider test")
    public void divider() {
        assertTrue(Divider.IsDivider(4, 2));
    }

    @Test
    @DisplayName("Divider test")
    public void notDivider() {
        assertFalse(Divider.IsDivider(4, 3));
    }
}
