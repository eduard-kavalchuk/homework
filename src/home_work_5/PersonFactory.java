package home_work_5;

import home_work_5.helpers.FileReader;
import home_work_5.helpers.NameGenerator;

import java.io.IOException;
import java.util.Random;

/**
 * Provides factory methods to create specific {@code Person} instances.
 * */
public class PersonFactory {
    /**
     * Factory method to create a {@code Person} instance with random Latin name.
     * @param nick nickname
     * @param password password
     * @return {@code Person} instance
     * */
    public static Person createWithRandomLatinName(String nick, String password) {
        return new Person(nick, password, NameGenerator.getRandomLatinString());
    }

    /**
     * Factory method to create a {@code Person} instance with random Latin nickname.
     * @param name name
     * @param password password
     * @return {@code Person} instance
     * */
    public static Person createWithRandomLatinNickname(String password, String name) {
        return new Person(NameGenerator.getRandomLatinString(), password, name);
    }

    /**
     * Factory method to create a {@code Person} instance with random Cyrillic name.
     * @param nick nickname
     * @param password password
     * @return {@code Person} instance
     * */
    public static Person createWithRandomCyrillicName(String nick, String password) {
        return new Person(nick, password, NameGenerator.getRandomCyrillicString());
    }

    /**
     * Factory method to create a {@code Person} instance with random Cyrillic nickname.
     * @param name name
     * @param password password
     * @return {@code Person} instance
     * */
    public static Person createWithRandomCyrillicNickname(String password, String name) {
        return new Person(NameGenerator.getRandomCyrillicString(), password, name);
    }

    /**
     * Factory method to create a {@code Person} instance with real Latin name fetched randomly from an
     * internal source.
     * @param nick nickname
     * @param password password
     * @return {@code Person} instance
     * */
    public static Person createWithRandomRealName(String nick, String password) {
        String[] names = FileReader.getInstance().getNames();
        int idx = new Random().nextInt(names.length);
        return new Person(nick, password, names[idx]);
    }

    /**
     * Factory method to create a {@code Person} instance with real Latin nickname fetched randomly from an
     * internal source.
     * @param name nickname
     * @param password password
     * @return {@code Person} instance
     * */
    public static Person createWithRandomRealNickname(String password, String name) {
        String[] names = FileReader.getInstance().getNames();
        int idx = new Random().nextInt(names.length);
        return new Person(names[idx], password, name);
    }

    /**
     * Factory method to create a {@code Person} instance with real Latin name fetched randomly from an
     * internal source.
     * @param nick nickname
     * @param password password
     * @param path path to file containing real Latin names
     * @return {@code Person} instance
     * @throws IOException in case when {@code path} is invalid
     * */
    public static Person createWithRandomNameFromFile(String nick, String password, String path) throws IOException {
        FileReader fr = FileReader.getInstance();
        String[] names = fr.readNamesFromFile(path);
        int idx = new Random().nextInt(names.length);
        return new Person(nick, password, names[idx]);
    }

    /**
     * Factory method to create a {@code Person} instance with real Latin nickname fetched randomly from an
     * internal source.
     * @param name name
     * @param password password
     * @param path path to file containing real Latin nicknames
     * @return {@code Person} instance
     * @throws IOException in case when {@code path} is invalid
     * */
    public static Person createWithRandomNicknameFromFile(String name, String password, String path) throws IOException {
        FileReader fr = FileReader.getInstance();
        String[] nicknames = fr.readNamesFromFile(path);
        int idx = new Random().nextInt(nicknames.length);
        return new Person(nicknames[idx], password, name);
    }
}
