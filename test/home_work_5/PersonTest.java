package home_work_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {
    private static final String LATIN_NICKNAME = "nickname";
    private static final String LATIN_NAME = "name";
    private static final String CYRILLIC_NICKNAME = "Этокличка";
    private static final String CYRILLIC_NAME = "Виталий";
    private static final String PASSWORD = "qwerty";
    private static final String PATH = String.join(File.separator, "test", "home_work_5", "names.txt");
    @Test
    @DisplayName("Person::createWithRandomLatinName()")
    public void createWithRandomLatinName() {
        Person person = PersonFactory.createWithRandomLatinName(LATIN_NICKNAME, PASSWORD);
        assertEquals(LATIN_NICKNAME, person.getNick());
        assertEquals(PASSWORD, person.getPassword());
        int len = person.getName().length();
        assertTrue(5 <= len && len <= 10);
        String name = person.getName();
        for (int i = 0; i < name.length(); i++) {
            int code = Character.codePointAt(name, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomLatinNickname()")
    public void createWithRandomLatinNickname() {
        Person person = PersonFactory.createWithRandomLatinNickname(PASSWORD, LATIN_NAME);
        assertEquals(LATIN_NAME, person.getName());
        assertEquals(PASSWORD, person.getPassword());
        int len = person.getNick().length();
        assertTrue(5 <= len && len <= 10);
        String nickname = person.getNick();
        for (int i = 0; i < nickname.length(); i++) {
            int code = Character.codePointAt(nickname, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomRussianName()")
    public void createWithRandomRussianName() {
        Person person = PersonFactory.createWithRandomCyrillicName(CYRILLIC_NICKNAME, PASSWORD);
        assertEquals(CYRILLIC_NICKNAME, person.getNick());
        assertEquals(PASSWORD, person.getPassword());
        int len = person.getName().length();
        assertTrue(5 <= len && len <= 10);
        String name = person.getName();
        for (int i = 0; i < name.length(); i++) {
            int code = Character.codePointAt(name, i);
            if (i == 0)
                assertTrue(1040 <= code && code <= 1071);
            else assertTrue(1072 <= code && code <= 1103);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomRussianNickname()")
    public void createWithRandomRussianNickname() {
        Person person = PersonFactory.createWithRandomRussianNickname(PASSWORD, CYRILLIC_NAME);
        assertEquals(CYRILLIC_NAME, person.getName());
        assertEquals(PASSWORD, person.getPassword());
        int len = person.getNick().length();
        assertTrue(5 <= len && len <= 10);
        String nickname = person.getNick();
        for (int i = 0; i < nickname.length(); i++) {
            int code = Character.codePointAt(nickname, i);
            if (i == 0)
                assertTrue(1040 <= code && code <= 1071);
            else assertTrue(1072 <= code && code <= 1103);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomRealName()")
    public void createWithRandomRealName() {
        Person person = PersonFactory.createWithRandomRealName(LATIN_NICKNAME, PASSWORD);
        assertEquals(LATIN_NICKNAME, person.getNick());
        assertEquals(PASSWORD, person.getPassword());
        // Length of name is not asserted since it can be other than [5, 10]
        String name = person.getName();
        for (int i = 0; i < name.length(); i++) {
            int code = Character.codePointAt(name, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomRealNickname()")
    public void createWithRandomRealNickname() {
        String nickname;
        Person person = PersonFactory.createWithRandomRealNickname(PASSWORD, LATIN_NAME);
        assertEquals(LATIN_NAME, person.getName());
        assertEquals(PASSWORD, person.getPassword());
        int len = person.getNick().length();
        assertTrue(5 <= len && len <= 10);
        nickname = person.getNick();
        for (int i = 0; i < nickname.length(); i++) {
            int code = Character.codePointAt(nickname, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomNameFromFile()")
    public void createWithRandomNameFromFile() throws IOException {
        Person person = PersonFactory.createWithRandomNameFromFile(LATIN_NICKNAME, PASSWORD, PATH);
        assertEquals(LATIN_NICKNAME, person.getNick());
        assertEquals(PASSWORD, person.getPassword());
        // Length of name is not asserted since it can be other than [5, 10]
        String name = person.getName();
        for (int i = 0; i < name.length(); i++) {
            int code = Character.codePointAt(name, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomNicknameFromFile()")
    public void createWithRandomNicknameFromFile() throws IOException {
        Person person = PersonFactory.createWithRandomNicknameFromFile(LATIN_NAME, PASSWORD, PATH);
        assertEquals(LATIN_NAME, person.getName());
        assertEquals(PASSWORD, person.getPassword());
        int len = person.getNick().length();
        assertTrue(5 <= len && len <= 10);
        String nickname = person.getNick();
        for (int i = 0; i < nickname.length(); i++) {
            int code = Character.codePointAt(nickname, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }
}
