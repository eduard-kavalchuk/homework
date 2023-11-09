package home_work_4;
aa
import home_work_4.DataContainer.DataContainer;
import home_work_4.DataContainer.StringComparator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class DataContainerTest {
    @Test
    @DisplayName("Add method")
    public void testToString() {
        String[] s = {"One", "Two", "Three"};
        DataContainer<String> container = new DataContainer<>(s);
        assertEquals("[One, Two, Three]", container.toString());
        container = new DataContainer<>(new String[0]);
        assertEquals("[]", container.toString());
    }

    @Test
    @DisplayName("Add method")
    public void testAdd() {
        DataContainer<String> container = new DataContainer<>(new String[0]);
        container.add("Item1");
        container.add("Item2");
        assertEquals("[Item1, Item2]", container.toString());
    }

    @Test
    @DisplayName("Index method")
    public void testIndex() {
        String[] s = {"One", "Two"};
        DataContainer<String> container = new DataContainer<>(s);
        assertEquals("One", container.get(0));
        assertEquals("Two", container.get(1));
        assertEquals(null, container.get(2));
    }

    @Test
    @DisplayName("Delete method")
    public void testDelete() {
        String[] s = {"One", "Two", "Three"};
        DataContainer<String> container = new DataContainer<>(s);
        container.delete(0);
        assertEquals("[Two, Three]", container.toString());
        container.delete(1);
        assertEquals("[Two]", container.toString());
        container.delete(0);
        assertEquals("[]", container.toString());
        container.delete(0);
        assertEquals("[]", container.toString());
    }

    @Test
    @DisplayName("GetItems method")
    public void testGetItems() {
        String[] expected = {"One", "Two", "Three"};
        DataContainer<String> container = new DataContainer<>(expected);
        String[] actual = container.getItems();
        assertArrayEquals(actual, expected);
    }

    @Test
    @DisplayName("Sort with instance comparator method")
    public void sortWithInstanceComparator() {
        String[] initial = {"3", "1", "5", "2"};
        String[] expected = {"1", "2", "3", "5"};
        DataContainer<String> container = new DataContainer<>(initial);
        container.sort(new StringComparator());
        assertArrayEquals(container.getItems(), expected);
    }

    @Test
    @DisplayName("Sort comparable method")
    public void sortComparable() {
        String[] initial = {"3", "1", "5", "2"};
        String[] expected = {"1", "2", "3", "5"};
        DataContainer<String> container = new DataContainer<>(initial);
        DataContainer.sort(container);
        assertArrayEquals(container.getItems(), expected);
    }

    @Test
    @DisplayName("Sort with static comparator method")
    public void sortWithStaticComparator() {
        String[] initial = {"3", "1", "5", "2"};
        String[] expected = {"1", "2", "3", "5"};
        DataContainer<String> container = new DataContainer<>(initial);
        DataContainer.sort(container);
        assertArrayEquals(container.getItems(), expected);
    }

    @Test
    @DisplayName("Sort with static comparator method")
    public void testIterator() {
        int i = 0;
        String[] initial = {"2", "e", "sd", "4w", "-2"};
        String[] array = new String[initial.length];
        DataContainer<String> container = new DataContainer<>(initial);
        for (String s : container)
            array[i++] = s;
        assertArrayEquals(container.getItems(), array);
    }
}
