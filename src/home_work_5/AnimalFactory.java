package home_work_5;

import home_work_5.helpers.FileReader;
import home_work_5.helpers.NameGenerator;

import java.io.IOException;
import java.util.Random;

public class AnimalFactory {
    public static Animal createWithRandomLatinNickname(int age) {
        return new Animal(age, NameGenerator.getRandomLatinString());
    }
    public static Animal createWithRandomRussianNickname(int age) {
        return new Animal(age, NameGenerator.getRandomCyrillicString());
    }
    public static Animal createWithRandomRealNickname(int age) {
        String[] nicknames = FileReader.getInstance().getNames();
        int idx = new Random().nextInt(nicknames.length);
        return new Animal(age, nicknames[idx]);
    }
    public static Animal createWithRandomNicknameFromFile(int age, String path) throws IOException {
        FileReader fr = FileReader.getInstance();
        String[] nicknames = fr.readNamesFromFile(path);
        int idx = new Random().nextInt(nicknames.length);
        return new Animal(age, nicknames[idx]);
    }

}
