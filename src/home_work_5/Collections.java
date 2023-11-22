package home_work_5;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        int size = 10;
        long t1;
        long t2;
        Person[] people = new Person[size];
        for (int i = 0; i < size; i++)
            people[i] = PersonFactory.createWithRandomLatinName(
                    "nickname", "password");

        t1 = System.nanoTime();
        ArrayList<Person> al = new ArrayList<>(List.of(people));
        t2 = System.nanoTime();
        System.out.println(t2 - t1);

        t1 = System.nanoTime();
        LinkedList<Person> ll = new LinkedList<>(List.of(people));
        t2 = System.nanoTime();
        System.out.println(t2 - t1);

        t1 = System.nanoTime();
        HashSet<Person> hs = new HashSet<>(List.of(people));
        t2 = System.nanoTime();
        System.out.println(t2 - t1);

        // TODO. Redefine hashCode() and equals() for Person and Animal and implement Comparable based on that
        t1 = System.nanoTime();
        TreeSet<Person> ts = new TreeSet<>(List.of(people));
        t2 = System.nanoTime();
        System.out.println(t2 - t1);

    }
}
