package home_work_2.utils;

public class SortsUtils {
    public static void sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = (arr.length - 1); j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void shake(int[] arr) {
        int left = 0, right = arr.length - 1;
        int flag = 1;
        int t;

        while ((left < right) && (flag > 0)) {
            flag = 0;
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                    flag = 1;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i - 1] > arr[i]) {
                    t = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = t;
                    flag = 1;
                }
            }
            left++;
        }
    }
}
