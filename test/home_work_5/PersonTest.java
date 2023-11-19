package home_work_5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
