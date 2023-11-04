package home_work_4.DataContainer;

import java.util.*;

public class DataContainer<T> implements Iterable<T> {
    /**
     * The array buffer into which the elements of the DataContainer are stored.
     */
    private T[] data;

    /**
     * The size of the DataContainer (the number of elements it contains).
     */
    private int size;

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs a container containing the elements of the specified array.
     * @param t the array whose elements are to be placed into this container
     */
    public DataContainer(T[] t) {
        if ((size = t.length) > DEFAULT_CAPACITY) {
            data = Arrays.copyOf(t, t.length * 2);
        } else {
            data = Arrays.copyOf(t, DEFAULT_CAPACITY);
        }
    }

    /**
     * Appends the specified element to the end of this container.
     * @param item element to be appended to this container
     * @return new size of this container
     */
    public int add(T item) {
        if (size == data.length) {
            data = grow();
        }
        data[size] = item;
        return size++;
    }

    /**
     * Returns the element at the specified position in this container.
     * @param index index of the element to return.
     * @return the element at the specified position this container. Null if index exceeds size.
     * */
    public T get(int index) {
        if (index < size)
            return data[index];
        return null;
    }

    private T[] grow() {
        return Arrays.copyOf(data, data.length * 2);
    }

    /**
     * Returns an array containing a shallow copy of the container elements in an array
     * */
    public T[] getItems() {
        return Arrays.copyOf(data, size);  // shallow copy!
    }

    /**
     * Removes the element at the specified position in this container.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * @param index the index of the element to be removed
     * @return true if index is less than size
     * */
    public boolean delete(int index) {
        if (index >= size)
            return false;
        T[] tmp = Arrays.copyOf(data, size - 1);
        for (int i = 0, k = 0; i < size; i++) {
            if (i == index)
                continue;
            tmp[k] = data[i];
            ++k;
        }
        data = tmp;
        --size;
        return true;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this container, or -1 if this container does not contain the element.
     * */
    public int indexOf(T t) {
        int i = 0;
        for (T d : data) {
            if (t == d)
                return i;
            ++i;
        }
        return -1;
    }

    /**
     * Removes the first occurrence of the specified element from this container,
     * if it is present.  If the container does not contain the element, it is
     * unchanged.
     * Returns {@code true} if this container contained the specified element.
     *
     * @param item element to be removed from this container, if present
     * @return {@code true} if this list contained the specified element
     */
    public boolean delete(T item) {
        int index = indexOf(item);
        if (index == -1)
            return false;
        return delete(index);
    }

    /**
     * Returns string representation of the container
     * */
    public String toString() {
        int i = 0;
        if (size == 0)
            return "[]";
        StringBuilder s = new StringBuilder();
        s.append('[');
        for (; i < size - 1; i++) {
            if (data[i] == null)
                continue;
            s.append(data[i].toString());
            s.append(", ");
        }
        s.append(data[i].toString());
        s.append(']');
        return s.toString();
    }

    /**
     * Sort the container with a help of comparator
     * */
    public void sort(Comparator<T> c) {
        for (int i = 0; i < size; i++)
            for (int j = i; j > 0 && c.compare(data[j-1], data[j]) > 0; j--)
                swap(j, j-1);
    }

    private void swap(int a, int b) {
        T t = data[a];
        data[a] = data[b];
        data[b] = t;
    }

    /**
     * Static version of the sort function for Comparable types
     * */
    public static <T extends Comparable<T>> void sort(DataContainer<T> container) {
        for (int i = 0; i < container.size; i++)
            for (int j = i; j > 0 && container.data[j-1].compareTo(container.data[j]) > 0; j--) {
                T t = container.data[j];
                container.data[j] = container.data[j - 1];
                container.data[j - 1] = t;
            }
    }

    /**
     * Static version of the sort function using comparator
     * */
    public static <T> void sort(DataContainer<T> container, Comparator<T> comparator) {
        for (int i = 0; i < container.size; i++)
            for (int j = i; j > 0 && comparator.compare(container.data[j-1], container.data[j]) > 0; j--) {
                T t = container.data[j];
                container.data[j] = container.data[j - 1];
                container.data[j - 1] = t;
            }
    }

    /**
     * Implementation of the Iterable interface
     * */
    public Iterator<T> iterator() {
        return new DataContainerIterator();
    }

    private class DataContainerIterator implements Iterator<T> {
        int currentIndex;       // index of next element to return
        public boolean hasNext() {
            return currentIndex != size;
        }
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[currentIndex++];
        }
    }

    public static void main(String[] args) {
        String[] s = {};
        DataContainer<String> container = new DataContainer<>(s);

        int index1 = container.add("Привет");
        int index2 = container.add("Как дела");
        int index3 = container.add("Работаю");
        int index4 = container.add("Давай потом");
        System.out.println("Content of container after adding four strings: " + container);

        String text1 = container.get(index1);
        String text2 = container.get(index2);
        String text3 = container.get(index3);
        String text4 = container.get(index4);
        System.out.println("First element: " + text1);  //Привет
        System.out.println("Second element: " + text2); //Как дела
        System.out.println("Third element: " + text3);  //Работаю
        System.out.println("Fourth element: " + text4); //Давай потом

        container.delete(text1);
        System.out.println("State of container after the first element is deleted: " + container);
        System.out.println("Current first element: " + container.get(index1)); //Как дела

        String[] stringArray = container.getItems();
        container.sort(new StringComparator());
        System.out.println("Container after being sorted with the help of comparator (non-static version): " + container);

        container = new DataContainer<>(stringArray);
        sort(container);
        System.out.println("Natural ordering of a container according of a type of its elements: " + container);

        container = new DataContainer<>(stringArray);
        sort(container, new StringComparator());
        System.out.println("Container after being sorted with the help of comparator (static version): " + container);

        System.out.println("Iteration over container:");
        for (String e : container)
            System.out.println(e);
    }
}
