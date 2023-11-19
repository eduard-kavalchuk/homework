package home_work_5;

import home_work_5.helpers.FileReader;
import home_work_5.helpers.NameGenerator;

import java.io.IOException;
import java.util.Random;

/**
 * Provides factory methods to create specific {@code Animal} instances.
 * */
public class AnimalFactory {
    /**
     * Factory method to create an {@code Animal} instance with random Latin nickname.
     * @param age
     * @return {@code Animal} instance
     * */
    public static Animal createWithRandomLatinNickname(int age) {
        return new Animal(age, NameGenerator.getRandomLatinString());
    }

    /**
     * Factory method to create an {@code Animal} instance with random Cyrillic nickname.
     * @param age
     * @return {@code Animal} instance
     * */
    public static Animal createWithRandomCyrillicNickname(int age) {
        return new Animal(age, NameGenerator.getRandomCyrillicString());
    }

    /**
     * Factory method to create a {@code Animal} instance with real Latin nickname fetched randomly from an
     * internal source.
     * @param age
     * @return {@code Animal} instance
     * */
    public static Animal createWithRandomRealNickname(int age) {
        String[] nicknames = FileReader.getInstance().getNames();
        int idx = new Random().nextInt(nicknames.length);
        return new Animal(age, nicknames[idx]);
    }

    /**
     * Factory method to create an {@code Animal} instance with real Latin nickname fetched randomly from an
     * internal source.
     * @param age
     * @param path path to file containing real Latin nicknames
     * @return {@code Animal} instance
     * @throws IOException in case when {@code path} is invalid
     * */
    public static Animal createWithRandomNicknameFromFile(int age, String path) throws IOException {
        FileReader fr = FileReader.getInstance();
        String[] nicknames = fr.readNamesFromFile(path);
        int idx = new Random().nextInt(nicknames.length);
        return new Animal(age, nicknames[idx]);
    }

}
