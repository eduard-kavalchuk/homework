package home_work_5.api;

import home_work_5.Person;

public class PersonComparatorByPasswordLength implements IComparator<Person> {
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getPassword().length(), o2.getPassword().length());
    }
}
