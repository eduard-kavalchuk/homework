package home_work_5.Task6;

import home_work_5.Person;

import java.util.LinkedList;
import java.util.List;

public class TreeSetCollection extends PeopleCollectionsManipulator {
    public TreeSetCollection(int collectionSize) {
        super(collectionSize);
    }

    public void calculateTimes() {
        int i = 0;
        String dummy;

        long t1 = System.nanoTime();
        LinkedList<Person> ll = new LinkedList<>(List.of(people));
        long t2 = System.nanoTime();
        System.out.println("\nКоллекция TreeSet:");
        System.out.println("Время заполнения: " +  (t2 - t1) + " нс");

        t1 = System.nanoTime();
        for (Person p : ll) {
            dummy = p.getName();
        }
        t2 = System.nanoTime();
        System.out.println("Время итерирования в цикле forEach: " +  (t2 - t1) + " нс");

        t1 = System.nanoTime();
        do {
            ++i;
            dummy = ll.get(i).getName();
        } while(i < ll.size() - 1);
        t2 = System.nanoTime();
        System.out.println("Время итерирования в цикле doWhile: " +  (t2 - t1) + " нс");

        t1 = System.nanoTime();
        for (i = 0; i < ll.size(); i++) {
            ll.remove(0);
        }
        t2 = System.nanoTime();
        System.out.println("Время удаления всех элементов: " +  (t2 - t1) + " нс");
    }
}
