package home_work_5.Task6;

import home_work_5.Person;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCollection extends PeopleCollectionsManipulator {
    public LinkedListCollection(int collectionSize) {
        super(collectionSize);
    }

    public void calculateTimes() {
        int i = 0;
        String dummy;

        long t1 = System.nanoTime();
        ArrayList<Person> al = new ArrayList<>(List.of(people));
        long t2 = System.nanoTime();
        System.out.println("Время заполнения коллекции ArrayList: " +  (t2 - t1) + " нс");

        t1 = System.nanoTime();
        for (Person p : al) {
            dummy = p.getName();
        }
        t2 = System.nanoTime();
        System.out.println("Время итерирования коллекции ArrayList в цикле forEach: " +  (t2 - t1) + " нс");

        t1 = System.nanoTime();
        do {
            ++i;
            dummy = al.get(i).getName();
        } while(i < al.size() - 1);
        t2 = System.nanoTime();
        System.out.println("Время итерирования коллекции ArrayList в цикле doWhile: " +  (t2 - t1) + " нс");

        t1 = System.nanoTime();
        for (i = 0; i < al.size(); i++) {
            al.remove(0);
        }
        t2 = System.nanoTime();
        System.out.println("Время удаления всех элементов из коллекции ArrayList: " +  (t2 - t1) + " нс");
    }

}
