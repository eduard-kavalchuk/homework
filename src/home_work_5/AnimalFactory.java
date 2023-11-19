package home_work_5;

import java.io.IOException;
import java.util.Random;

public class AnimalFactory {
    public static Animal createWithRandomLatinNickname(int age) {
        return new Animal(age, randomLatinStringGenerator());
    }
    public static Animal createWithRandomRussianNickname(int age) {
        return new Animal(age, randomCyrillicStringGenerator());
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
