package home_work_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {
    @Test
    @DisplayName("Person::createWithRandomLatinName()")
    public void createWithRandomLatinName() {
        int len;
        int code;
        String name;
        String nickname = "nickname";
        String password = "qwerty";
        Person person = PersonFactory.createWithRandomLatinName(nickname, password);
        assertEquals(nickname, person.getNick());
        assertEquals(password, person.getPassword());
        len = person.getName().length();
        assertTrue(5 <= len && len <= 10);
        name = person.getName();
        for (int i = 0; i < name.length(); i++) {
            code = Character.codePointAt(name, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomLatinNickname()")
    public void createWithRandomLatinNickname() {
        int len;
        int code;
        String nickname;
        String name = "name";
        String password = "qwerty";
        Person person = PersonFactory.createWithRandomLatinNickname(password, name);
        assertEquals(name, person.getName());
        assertEquals(password, person.getPassword());
        len = person.getNick().length();
        assertTrue(5 <= len && len <= 10);
        nickname = person.getNick();
        for (int i = 0; i < nickname.length(); i++) {
            code = Character.codePointAt(nickname, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomRussianName()")
    public void createWithRandomRussianName() {
        int len;
        int code;
        String name;
        String nickname = "кличка";
        String password = "qwerty";
        Person person = PersonFactory.createWithRandomRussianName(nickname, password);
        assertEquals(nickname, person.getNick());
        assertEquals(password, person.getPassword());
        len = person.getName().length();
        assertTrue(5 <= len && len <= 10);
        name = person.getName();
        for (int i = 0; i < name.length(); i++) {
            code = Character.codePointAt(name, i);
            if (i == 0)
                assertTrue(1040 <= code && code <= 1071);
            else assertTrue(1072 <= code && code <= 1103);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomRussianNickname()")
    public void createWithRandomRussianNickname() {
        int len;
        int code;
        String nickname;
        String name = "Этоимя";
        String password = "qwerty";
        Person person = PersonFactory.createWithRandomRussianNickname(password, name);
        assertEquals(name, person.getName());
        assertEquals(password, person.getPassword());
        len = person.getNick().length();
        assertTrue(5 <= len && len <= 10);
        nickname = person.getNick();
        for (int i = 0; i < nickname.length(); i++) {
            code = Character.codePointAt(nickname, i);
            if (i == 0)
                assertTrue(1040 <= code && code <= 1071);
            else assertTrue(1072 <= code && code <= 1103);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomRealName()")
    public void createWithRandomRealName() {
        int code;
        String name;
        String nickname = "nickname";
        String password = "qwerty";
        Person person = PersonFactory.createWithRandomRealName(nickname, password);
        assertEquals(nickname, person.getNick());
        assertEquals(password, person.getPassword());
        // Length of name is not asserted since it can be other than [5, 10]
        name = person.getName();
        for (int i = 0; i < name.length(); i++) {
            code = Character.codePointAt(name, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomRealNickname()")
    public void createWithRandomRealNickname() {
        int len;
        int code;
        String nickname;
        String name = "name";
        String password = "qwerty";
        Person person = PersonFactory.createWithRandomRealNickname(password, name);
        assertEquals(name, person.getName());
        assertEquals(password, person.getPassword());
        len = person.getNick().length();
        assertTrue(5 <= len && len <= 10);
        nickname = person.getNick();
        for (int i = 0; i < nickname.length(); i++) {
            code = Character.codePointAt(nickname, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomNameFromFile()")
    public void createWithRandomNameFromFile() throws IOException {
        int code;
        String name;
        String nickname = "nickname";
        String password = "qwerty";
        String path = String.join(File.separator, "test", "home_work_5", "names.txt");
        Person person = PersonFactory.createWithRandomNameFromFile(nickname, password, path);
        assertEquals(nickname, person.getNick());
        assertEquals(password, person.getPassword());
        // Length of name is not asserted since it can be other than [5, 10]
        name = person.getName();
        for (int i = 0; i < name.length(); i++) {
            code = Character.codePointAt(name, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }
    @Test
    @DisplayName("Person::createWithRandomNicknameFromFile()")
    public void createWithRandomNicknameFromFile() throws IOException {
        int len;
        int code;
        String nickname;
        String name = "name";
        String password = "qwerty";
        String path = String.join(File.separator, "test", "home_work_5", "names.txt");
        Person person = PersonFactory.createWithRandomNicknameFromFile(name, password, path);
        assertEquals(name, person.getName());
        assertEquals(password, person.getPassword());
        len = person.getNick().length();
        assertTrue(5 <= len && len <= 10);
        nickname = person.getNick();
        for (int i = 0; i < nickname.length(); i++) {
            code = Character.codePointAt(nickname, i);
            if (i == 0)
                assertTrue(65 <= code && code <= 90);
            else assertTrue(97 <= code && code <= 122);
        }
    }
}
