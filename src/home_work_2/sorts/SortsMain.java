package home_work_2.sorts;

import java.util.Arrays;
import home_work_2.utils.ArraysUtils;
import home_work_2.utils.SortsUtils;

class SortsMain {
    public static void print(int[] array) {
        // Make a copy of original array in order to apply shaker sort to it later
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, arrayCopy.length);

        System.out.print("Bubble sort: ");
        System.out.print(Arrays.toString(array));
        SortsUtils.sort(array);
        System.out.println(" -> " + Arrays.toString(array));

        System.out.print("Shaker sort: ");
        System.out.print(Arrays.toString(arrayCopy));
        SortsUtils.shake(arrayCopy);
        System.out.println(" -> " + Arrays.toString(arrayCopy));
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        SortsMain.print(array);

        array = new int[]{1, 1, 1, 1};
        SortsMain.print(array);

        array = new int[]{9, 1, 5, 99, 9, 9};
        SortsMain.print(array);

        array = new int[]{};
        SortsMain.print(array);

        array = new int[]{6, 5, 4, 3, 2, 1};
        SortsMain.print(array);

        array = ArraysUtils.arrayRandom(50, 100);
        SortsMain.print(array);

        array = ArraysUtils.arrayFromConsole();
        SortsMain.print(array);
    }
}
