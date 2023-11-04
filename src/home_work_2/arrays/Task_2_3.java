package home_work_2.arrays;

import java.util.Arrays;
import home_work_2.utils.ArraysUtils;

abstract interface IArraysOperation {
    void DoWhileOperation(int[] array);
    void WhileOperation(int[] array);
    void ForOperation(int[] array);
    void ForEachOperation(int[] array);
}

class PrintAllElements implements IArraysOperation {
    public void DoWhileOperation(int[] array) {
        int k = 0;
        do {
            System.out.print(array[k++] + " ");
        } while (k < array.length);
        System.out.println();
    }

    public void WhileOperation(int[] array) {
        int k = 0;
        while (k < array.length)
            System.out.print(array[k++] + " ");
        System.out.println();
    }

    public void ForOperation(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public void ForEachOperation(int[] array) {
        for (int e : array)
            System.out.print(e + " ");
        System.out.println();
    }
}

class PrintEachSecondElement implements IArraysOperation {
    public void DoWhileOperation(int[] array) {
        int k = 0;
        do {
            System.out.print(array[k] + " ");
            k += 2;
        } while (k < array.length);
        System.out.println();
    }

    public void WhileOperation(int[] array) {
        int k = 0;
        while (k < array.length) {
            System.out.print(array[k] + " ");
            k += 2;
        }
        System.out.println();
    }

    public void ForOperation(int[] array) {
        for (int i = 0; i < array.length; i += 2)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public void ForEachOperation(int[] array) {
        int k = 0;
        for (int e : array) {
            if (k++ % 2 == 0)
                System.out.print(e + " ");
        }
        System.out.println();
    }
}

class ReverseArray implements IArraysOperation {
    public void DoWhileOperation(int[] array) {
        int k = array.length - 1;
        do {
            System.out.print(array[k] + " ");
        } while (--k >= 0);
        System.out.println();
    }

    public void WhileOperation(int[] array) {
        int k = array.length;
        while (--k >= 0) {
            System.out.print(array[k] + " ");
        }
        System.out.println();
    }

    public void ForOperation(int[] array) {
        for (int i = array.length - 1; i >= 0; i--)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public void ForEachOperation(int[] array) {
        String s = "";
        for (int e : array) {
            s = e + " " + s;
        }
        System.out.println(s);
    }
}

public class Task_2_3 {
    public static void main(String[] args) {
        PrintAllElements printAllElements = new PrintAllElements();
        PrintEachSecondElement printEachSecondElement = new PrintEachSecondElement();
        ReverseArray reverseArray = new ReverseArray();

        int[] array = ArraysUtils.arrayFromConsole();
        System.out.println("Initial array: " + Arrays.toString(array));

        printAllElements.DoWhileOperation(array);
        printAllElements.ForEachOperation(array);
        printAllElements.ForOperation(array);
        printAllElements.WhileOperation(array);

        printEachSecondElement.DoWhileOperation(array);
        printEachSecondElement.ForEachOperation(array);
        printEachSecondElement.ForOperation(array);
        printEachSecondElement.WhileOperation(array);
        
        reverseArray.DoWhileOperation(array);
        reverseArray.ForEachOperation(array);
        reverseArray.ForOperation(array);
        reverseArray.WhileOperation(array);
    }
}