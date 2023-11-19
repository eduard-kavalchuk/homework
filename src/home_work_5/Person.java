package home_work_5;

import home_work_5.api.IComparator;
import home_work_5.api.PersonComparatorByPasswordLength;
import home_work_5.api.PersonComparatorByPasswordLengthAndNickname;

public class Person {
    private final String nick;
    private final String password;
    private final String name;
    public Person(String nick, String password, String name) {
        this.nick = nick;
        this.password = password;
        this.name = name;
    }
    public String getNick() {
        return nick;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public static void sortByPasswordLength(Person[] people) {
        sort(people, new PersonComparatorByPasswordLength());
    }
    public static void sortByPasswordLengthAndNickname(Person[] people) {
        sort(people, new PersonComparatorByPasswordLengthAndNickname());
    }
    private static void sort(Person[] people, IComparator<Person> comparator) {
        for (int i = 0; i < people.length; i++)
            for (int j = i; j > 0 && comparator.compare(people[j-1], people[j]) > 0; j--) {
                swap(people, j, j - 1);
            }
    }
    private static void swap(Person[] people, int a, int b) {
        Person t = people[a];
        people[a] = people[b];
        people[b] = t;
    }
}
