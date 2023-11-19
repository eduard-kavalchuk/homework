package home_work_5;

import java.io.IOException;
import java.util.Random;

public class PersonFactory {
    public static Person createWithRandomLatinName(String nick, String password) {
        return new Person(nick, password, randomLatinStringGenerator());
    }
    public static Person createWithRandomLatinNickname(String password, String name) {
        return new Person(randomLatinStringGenerator(), password, name);
    }
    public static Person createWithRandomRussianName(String nick, String password) {
        return new Person(nick, password, randomCyrillicStringGenerator());
    }
    public static Person createWithRandomRussianNickname(String password, String name) {
        return new Person(randomCyrillicStringGenerator(), password, name);
    }
    public static Person createWithRandomRealName(String nick, String password) {
        String[] names = FileReader.getInstance().getNames();
        int idx = new Random().nextInt(names.length);
        return new Person(nick, password, names[idx]);
    }
    public static Person createWithRandomRealNickname(String password, String name) {
        String[] names = FileReader.getInstance().getNames();
        int idx = new Random().nextInt(names.length);
        return new Person(names[idx], password, name);
    }
    public static Person createWithRandomNameFromFile(String nick, String password, String path) throws IOException {
        FileReader fr = FileReader.getInstance();
        String[] names = fr.readNamesFromFile(path);
        int idx = new Random().nextInt(names.length);
        return new Person(nick, password, names[idx]);
    }
    public static Person createWithRandomNicknameFromFile(String name, String password, String path) throws IOException {
        FileReader fr = FileReader.getInstance();
        String[] nicknames = fr.readNamesFromFile(path);
        int idx = new Random().nextInt(nicknames.length);
        return new Person(nicknames[idx], password, name);
    }
    private static String randomStringGenerator(int min, int max) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        int len = random.nextInt(5) + 5;  // generate sequence of length [5, 10]
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
