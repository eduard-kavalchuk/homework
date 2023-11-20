package home_work_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalTest {
    private static final int AGE = 5;
    private static final String PATH = String.join(File.separator, "test", "home_work_5", "names.txt");

    @Test
    @DisplayName("Animal::createWithRandomLatinNickname()")
    public void createWithRandomLatinNickname() {
        Animal animal = AnimalFactory.createWithRandomLatinNickname(AGE);
        assertEquals(AGE, animal.getAge());
        String nickname = animal.getNick();
        int len = nickname.length();
        assertTrue(5 <= len && len <= 10);
        for (int i = 0; i < nickname.length(); i++) {
            int code = Character.codePointAt(nickname, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }

    @Test
    @DisplayName("Animal::createWithRandomCyrillicNickname()")
    public void createWithRandomCyrillicNickname() {
        Animal animal = AnimalFactory.createWithRandomCyrillicNickname(AGE);
        assertEquals(AGE, animal.getAge());
        String nickname = animal.getNick();
        int len = nickname.length();
        assertTrue(5 <= len && len <= 10);
        for (int i = 0; i < nickname.length(); i++) {
            int code = Character.codePointAt(nickname, i);
            if (i == 0)
                assertTrue(1040 <= code && code <= 1071);
            else assertTrue(1072 <= code && code <= 1103);
        }
    }

    @Test
    @DisplayName("Animal::createWithRandomRealNickname()")
    public void createWithRandomRealNickname() {
        Animal animal = AnimalFactory.createWithRandomRealNickname(AGE);
        assertEquals(AGE, animal.getAge());
        // Length of nickname is not asserted since it can be other than [5, 10]
        String nickname = animal.getNick();
        for (int i = 0; i < nickname.length(); i++) {
            int code = Character.codePointAt(nickname, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }

    @Test
    @DisplayName("Animal::createWithRandomNicknameFromFile()")
    public void createWithRandomNicknameFromFile() throws IOException {
        Animal animal = AnimalFactory.createWithRandomNicknameFromFile(AGE, PATH);
        assertEquals(AGE, animal.getAge());
        // Length of nickname is not asserted since it can be other than [5, 10]
        String nickname = animal.getNick();
        for (int i = 0; i < nickname.length(); i++) {
            int code = Character.codePointAt(nickname, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }
}
