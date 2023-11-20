package home_work_5.helpers;

public class Sort {
    /**
     * Sorts an array of instances of generic type
     * @param objects array of instances of generic type {@code T} to be sorted
     * @param comparator comparator that is used to compare two instances of type {@code T}
     * */
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
