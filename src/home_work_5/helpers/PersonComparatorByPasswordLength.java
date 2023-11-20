package home_work_5.helpers;

import home_work_5.Person;

public class PersonComparatorByPasswordLength implements IComparator<Person> {
    /**
     * Implements comparison of two {@code Persons} by their password length.
     * @param  o1 the first {@code Person} to compare
     * @param  o2 the second {@code Person} to compare
     * @return the value {@code 0} if {@code o1.password.length == o2.password.length};
     *         a value less than {@code 0} if {@code o1.password.length < o2.password.length}; and
     *         a value greater than {@code 0} if {@code o1.password.length > o2.password.length}
     * */
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getPassword().length(), o2.getPassword().length());
    }
}
