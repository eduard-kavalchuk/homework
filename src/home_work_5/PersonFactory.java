package home_work_5;

import home_work_5.helpers.FileReader;
import home_work_5.helpers.NameGenerator;

import java.io.IOException;
import java.util.Random;

public class PersonFactory {
    public static Person createWithRandomLatinName(String nick, String password) {
        return new Person(nick, password, NameGenerator.getRandomLatinString());
    }
    public static Person createWithRandomLatinNickname(String password, String name) {
        return new Person(NameGenerator.getRandomLatinString(), password, name);
    }
    public static Person createWithRandomRussianName(String nick, String password) {
        return new Person(nick, password, NameGenerator.getRandomCyrillicString());
    }
    public static Person createWithRandomRussianNickname(String password, String name) {
        return new Person(NameGenerator.getRandomCyrillicString(), password, name);
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

}
