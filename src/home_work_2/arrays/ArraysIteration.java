package home_work_2.arrays;

import java.util.Arrays;
import home_work_2.utils.ArraysUtils;

public class ArraysIteration {
    public static void task_2_2_1() {
        int[] array = ArraysUtils.arrayRandom(10, 100);
        int k;

        System.out.println("Initial array: " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();

        k = 0;
        do {
            System.out.print(array[k++] + " ");
        } while (k < array.length);
        System.out.println();

        k = 0;
        while (k < array.length)
            System.out.print(array[k++] + " ");
        System.out.println();

        for (int e : array)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void task_2_2_2() {
        int[] array = ArraysUtils.arrayRandom(10, 100);
        int k;

        System.out.println("Initial array: " + Arrays.toString(array));

        for (int i = 0; i < array.length; i += 2)
            System.out.print(array[i] + " ");
        System.out.println();

        k = 0;
        do {
            System.out.print(array[k] + " ");
            k += 2;
        } while (k < array.length);
        System.out.println();

        k = 0;
        while (k < array.length) {
            System.out.print(array[k] + " ");
            k += 2;
        }
        System.out.println();

        k = 0;
        for (int e : array) {
            if (k++ % 2 == 0)
                System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void task_2_2_3() {
        int[] array = ArraysUtils.arrayRandom(10, 100);
        int k;

        System.out.println("Initial array: " + Arrays.toString(array));

        for (int i = array.length - 1; i >= 0; i--)
            System.out.print(array[i] + " ");
        System.out.println();

        k = array.length - 1;
        do {
            System.out.print(array[k] + " ");
        } while (--k >= 0);
        System.out.println();

        k = array.length;
        while (--k >= 0) {
            System.out.print(array[k] + " ");
        }
        System.out.println();

        String s = "";
        for (int e : array) {
            s = e + " " + s;
        }
        System.out.println(s);
    }
}
