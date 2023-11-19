package home_work_5.helpers;

import java.util.Random;

/**
 * Provides helper methods for generating random capitalized Latin and Cyrillic
 * character sequences.
 * */
public class NameGenerator {
    /**
     * Generates a random character sequence in a target alphabet.
     * Target alphabet is specified by providing first and last character codes of this alphabet
     * as per UTF-8 table.
     * First character is capitalized. The returned sequence is 5 to 10 characters long.
     * @param min starting UTF-8 character code
     * @param max finishing UTF-8 character code
     * @return Random string in a target alphabet
     * */
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

    /**
     * Generates a random capitalized Latin character sequence
     * */
    public static String getRandomLatinString() {
        return randomStringGenerator(97, 122);
    }

    /**
     * Generates a random capitalized Cyrillic character sequence
     * */
    public static String getRandomCyrillicString() {
        return randomStringGenerator(1072, 1103);
    }
}
