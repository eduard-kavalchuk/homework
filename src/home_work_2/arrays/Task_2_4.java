package home_work_2.arrays;

import java.util.Arrays;
import home_work_2.utils.ArraysUtils;

public class Task_2_4 {
    public static int task_2_4_1() {
        int[] array = ArraysUtils.arrayRandom(50, 100);
        int sum = 0;
        for (int e : array) {
            if (e != 0 && e % 2 == 0)
                sum += e;
        }
        return sum;
    }

    public static int task_2_4_2() {
        int[] array = ArraysUtils.arrayRandom(50, 100);
        int max = 0;
        for (int i = 2; i < array.length; i += 2) {
            max = array[i] > max ? array[i] : max;
        }
        return max;
    }

    public static int[] task_2_4_3() {
        int[] array = ArraysUtils.arrayRandom(50, 100);
        double mean = (double) sum() / array.length;
        int newSize = 0;
        int[] smallNumbersArray;
        int j = 0;
        for (int e : array) {
            if (e < mean) ++newSize;
        }
        smallNumbersArray = new int[newSize];
        for (int e : array) {
            if (e < mean) {
                smallNumbersArray[j++] = e;
            }
        }
        return smallNumbersArray;
    }

    public static int[] task_2_4_5(int lowerBound, int upperBound) {
        int[] array = ArraysUtils.arrayRandom(50, 100);
        int newSize = array.length;
        int[] compressedArray;
        int j = 0;
        for (int e : array) {
            if (e >= lowerBound && e <= upperBound) --newSize;
        }
        compressedArray = new int[newSize];
        for (int e : array) {
            if (e < lowerBound || e > upperBound)
                compressedArray[j++] = e;
        }
        return compressedArray;
    }

    // Task 2.4.6
    public static int sum() {
        int[] array = ArraysUtils.arrayRandom(50, 100);
        int sum = 0;
        for (int e : array)
            sum += e;
        return sum;
    }
}

class Demo {
    public static void main(String[] args) {
        int[] array = Task_2_4.task_2_4_5(10, 90);
        System.out.println(Arrays.toString(array));
    }
}
