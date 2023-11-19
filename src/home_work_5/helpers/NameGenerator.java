package home_work_5.helpers;

import java.util.Random;

public class NameGenerator {
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
    public static String getRandomLatinString() {
        return randomStringGenerator(97, 122);
    }
    public static String getRandomCyrillicString() {
        return randomStringGenerator(1072, 1103);
    }
}
