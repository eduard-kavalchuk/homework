package home_work_2.loops;

import java.util.Random;
import java.util.Arrays;

class Task1_5 {
    private static int task_1_5_1(Integer input) {
        int max = 0;
        int tmp;
        String str = Integer.toString(input);

        for (int i = 0; i < str.length(); i++) {
            tmp = Character.getNumericValue(str.charAt(i));
            if (max < tmp) max = tmp;
        }

        return max;
    }

    private static double task_1_5_2(byte upperBound, byte sampleSize) {
        int total = 0;
        int even = 0;
        int number;
        int[] array = new int[sampleSize];
        Random random = new Random();

        for (int i = 0; i < sampleSize; i++) {
            number = random.nextInt(upperBound) + 1;
            array[i] = number;
            if (number % 2 == 0)
                ++even;
            ++total;
        }
        System.out.println("Sample: " + Arrays.toString(array));
        System.out.println("Even numbers: " + even + " of " + total);
        return 100.0 * even / total;
    }

    private static void task_1_5_3(Integer input) {
        int even = 0;
        String str = Integer.toString(input);

        for (int i = 0; i < str.length(); i++) {
            if (Character.getNumericValue(str.charAt(i)) % 2 == 0)
                ++even;
        }

        System.out.println("Чётных цифр: " + even);
        System.out.println("Нечётных цифр: " + (str.length() - even));
    }

    // Task 1.5.4
    private static int fiboElement(int n)
    {
        if(n < 2) return n;

        return fiboElement(n - 1) + fiboElement(n - 2);
    }

    public static String fibonacci(int n) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (; i < n; i++) {
            sb.append(fiboElement(i) + " ");
        }
        sb.append(fiboElement(i));
        return sb.toString();
    }

    private static void task_1_5_5(byte start, byte stop, byte step) {
        if (step == 0)
            return;

        if (step > 0)
            for (int i = start; i < stop; i +=step) {
                System.out.println(i);
            }
        else
            for (int i = start; i > stop; i +=step) {
                System.out.println(i);
            }
    }

    private static long task_1_5_6(long input) {
        String str = Long.toString(input);
        String tmp = "";
        for (int i = str.length() - 1; i >= 0; --i)
            tmp += str.charAt(i);
        return Long.parseLong(tmp);
    }

    public static void main(String[] args) {
        /*
        // Task 1.5.1
        int i = Integer.parseInt(args[0]);
        System.out.println(task_1_5_1(i));
        */

        /*
        // Task 1.5.2
        Byte upperBound = Byte.parseByte(args[0]);
        Byte sampleSize = Byte.parseByte(args[1]);
        String prefix = "Вероятность четных случайных чисел в интервале [1, "
                        .concat(upperBound.toString())
                        .concat("] при размере выборки в ")
                        .concat(sampleSize.toString())
                        .concat(" элементов");
        System.out.println(prefix + ": " + String.format("%,.2f", task_1_5_2(upperBound, sampleSize)) + "%");
        */

        /*
        // Task 1.5.3
        int i = Integer.parseInt(args[0]);
        task_1_5_3(i);
        */

        /*
        // Task 1.5.4
        fibonacci(Integer.parseInt(args[0]));
        */
        
        /*
        // Task 1.5.5
        byte start = Byte.parseByte(args[0]);
        byte stop = Byte.parseByte(args[1]);
        byte step = Byte.parseByte(args[2]);
        task_1_5_5(start, stop, step);
        */

        // Task 1.5.6
        long l = Long.parseLong(args[0]);
        System.out.println(task_1_5_6(l));
    }
}
