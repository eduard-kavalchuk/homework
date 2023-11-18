package home_work_5;

import java.util.Random;

public class PersonFactory {
    public static Person createWithRandomName(String nick, String password) {
        return new Person(nick, password, "abc");
    }
    public static Person createWithRandomRussianName(String nick, String password) {
        return new Person(nick, password, "abc");
    }
    public static Person createWithRandomRealName(String nick, String password) {
        return new Person(nick, password, "abc");
    }
    public static Person createWithNameFromFile(String nick, String password) {
        return new Person(nick, password, "abc");
    }
    private static String randomStringGenerator(int min, int max) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        int utf8Code = random.nextInt(max - min) + min;
        builder.appendCodePoint(utf8Code - 32);
        for (int i = 0; i < 9; i++) {
            utf8Code = random.nextInt(max - min) + min;
            builder.appendCodePoint(utf8Code);
        }
        return builder.toString();
    }
}
