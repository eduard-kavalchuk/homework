package home_work_5;

import java.util.Random;

public class PersonFactory {
    public static Person createWithRandomLatinName(String nick, String password) {
        return new Person(nick, password, randomLatinStringGenerator());
    }
    public static Person createWithRandomRussianName(String nick, String password) {
        return new Person(nick, password, randomCyrillicStringGenerator());
    }
    public static Person createWithRandomRealName(String nick, String password) {
        String[] names = FileReader.getInstance().getNames();
        int idx = new Random().nextInt(names.length);
        return new Person(nick, password, names[idx]);
    }
    public static Person createWithNameFromFile(String nick, String password) {
        return new Person(nick, password, "abc");
    }
    private static String randomStringGenerator(int min, int max) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        int len = random.nextInt(5) + 5;
        int utf8Code = random.nextInt(max - min) + min;
        builder.appendCodePoint(utf8Code - 32); // convert first letter from lowercase to uppercase
        for (int i = 0; i < len - 1; i++) {
            utf8Code = random.nextInt(max - min) + min;
            builder.appendCodePoint(utf8Code);
        }
        return builder.toString();
    }
    private static String randomLatinStringGenerator() {
        return randomStringGenerator(97, 122);
    }
    private static String randomCyrillicStringGenerator() {
        return randomStringGenerator(1072, 1103);
    }

}
