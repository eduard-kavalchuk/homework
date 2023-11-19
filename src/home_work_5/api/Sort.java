package home_work_5.api;

public class Sort {
    public static <T> void sort(T[] objects, IComparator<T> comparator) {
        T t;
        for (int i = 0; i < objects.length; i++)
            for (int j = i; j > 0 && comparator.compare(objects[j-1], objects[j]) > 0; j--) {
                t = objects[j];
                objects[j] = objects[j - 1];
                objects[j - 1] = t;
            }
    }
}
