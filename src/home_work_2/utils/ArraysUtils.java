package home_work_2.utils;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ArraysUtils {
    public static int[] arrayFromConsole() {
        int size;
        int element;
        int counter = 0;
        int[] array;
        
        try (Scanner scanner = new Scanner(System.in)) {
            for (;;) {
                System.out.print("Enter array size: ");
                try {
                    size = scanner.nextInt();
                    if (size <= 0)
                        throw new InputMismatchException();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Only positive integer is excepted.");
                    scanner.nextLine();
                }
            }

            array = new int[size];
            for (;;) {
                System.out.print("Enter element " + (counter + 1) + ": ");
                try {
                    element = scanner.nextInt();
                    array[counter] = element;
                    if(++counter == size) break;
                } catch (InputMismatchException e) {
                    System.out.println("Only integers are excepted.");
                    scanner.nextLine();
                }
            }
        }

        return array;
    }

    public static int[] arrayRandom(int size, int maxValueExclusion) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValueExclusion);
        }
        return array;
    }
}
