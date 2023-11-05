package home_work_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class TestVasya {
    Vasya vasya = new Vasya();

    @Test
    @DisplayName("Greet1 test")
    public void greet1() {
        assertEquals(
                "Привет!\nЯ тебя так долго ждал.",
                vasya.greet1("Вася")
        );
        assertEquals(
                "Я тебя так долго ждал.",
                vasya.greet1("Анастасия")
        );
        assertEquals(
                "Добрый день, а вы кто?",
                vasya.greet1("Слава")
        );
    }

    @Test
    @DisplayName("Greet2 test")
    public void greet2() {
        assertEquals(
                "Привет!\nЯ тебя так долго ждал.",
                vasya.greet1("Вася")
        );
        assertEquals(
                "Я тебя так долго ждал.",
                vasya.greet1("Анастасия")
        );
        assertEquals(
                "Добрый день, а вы кто?",
                vasya.greet1("Слава")
        );
    }

    @Test
    @DisplayName("Greet3 test")
    public void greet3() {
        assertEquals(
                "Привет!\nЯ тебя так долго ждал.",
                vasya.greet1("Вася")
        );
        assertEquals(
                "Я тебя так долго ждал.",
                vasya.greet1("Анастасия")
        );
        assertEquals(
                "Добрый день, а вы кто?",
                vasya.greet1("Слава")
        );
    }
}
