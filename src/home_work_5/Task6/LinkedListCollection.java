package home_work_5.Task6;

import home_work_5.Person;

import java.util.LinkedList;
import java.util.List;

/**
 * Реализует проверку скорости выполнения операций коллекции LinkedList
 * */
public class LinkedListCollection extends PeopleCollectionsManipulator {
    public LinkedListCollection(int collectionSize) {
        super(collectionSize);
    }

    public void calculateTimes() {
        int i = 0;
        String dummy;

        long t1 = System.nanoTime();
        LinkedList<Person> collection = new LinkedList<>(List.of(people));
        long t2 = System.nanoTime();
        System.out.println("\nКоллекция LinkedList:");
        System.out.println("Время заполнения: " +  (t2 - t1) + " нс");

        t1 = System.nanoTime();
        for (Person p : collection) {
            dummy = p.getName();
        }
        t2 = System.nanoTime();
        System.out.println("Время итерирования в цикле forEach: " +  (t2 - t1) + " нс");

        t1 = System.nanoTime();
        do {
            ++i;
            dummy = collection.get(i).getName();
        } while(i < collection.size() - 1);
        t2 = System.nanoTime();
        System.out.println("Время итерирования в цикле doWhile: " +  (t2 - t1) + " нс");

        t1 = System.nanoTime();
        for (i = 0; i < collection.size(); i++) {
            collection.remove(0);
        }
        t2 = System.nanoTime();
        System.out.println("Время удаления всех элементов по одному: " +  (t2 - t1) + " нс");
    }

}
