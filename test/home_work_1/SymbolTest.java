package home_work_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SymbolTest {
    @Test
    @DisplayName("Symbol")
    public void symbol() {
        assertTrue(IsSymbol.isSymbol("c"));
    }

    @Test
    @DisplayName("Not symbol")
    public void notSymbol() {
        assertFalse(IsSymbol.isSymbol(","));
    }
}
