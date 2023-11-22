package home_work_5.Task6;

import home_work_5.Person;

import java.util.List;
import java.util.TreeSet;

public class TreeSetCollection extends PeopleCollectionsManipulator {
    public TreeSetCollection(int collectionSize) {
        super(collectionSize);
    }

    public void calculateTimes() {
        int i = 0;
        String dummy;

        long t1 = System.nanoTime();
        TreeSet<Person> collection = new TreeSet<>(List.of(people));
        long t2 = System.nanoTime();
        System.out.println("\nКоллекция TreeSet:");
        System.out.println("Время заполнения: " +  (t2 - t1) + " нс");

        Person[] people = new Person[collection.size()];
        t1 = System.nanoTime();
        for (Person p : collection) {
            people[i++] = p;
        }
        t2 = System.nanoTime();
        System.out.println("Время итерирования в цикле forEach: " +  (t2 - t1) + " нс");

        t1 = System.nanoTime();
        for (i = 0; i < people.length; i++) {
            collection.remove(people[i]);
        }
        t2 = System.nanoTime();
        System.out.println("Время удаления всех элементов по одному: " +  (t2 - t1) + " нс");
    }
}
