package home_work_5;

import home_work_5.helpers.PersonComparatorByPasswordLength;
import home_work_5.helpers.PersonComparatorByPasswordLengthAndNickname;
import home_work_5.helpers.Sort;

/**
 * DTO class Person.
 * Since DTO classes are designed to transfer immutable objects all fields of this class are declared {@code final}.
 * Setters are not implemented since field values are assigned once during constructor call.
 * To create Person instances with special properties use PersonFactory factory class.
 * */
public class Person {
    private final String nick;
    private final String password;
    private final String name;
    public Person(String nick, String password, String name) {
        this.nick = nick;
        this.password = password;
        this.name = name;
    }
    public String getNick() { return nick; }
    public String getPassword() { return password; }
    public String getName() { return name; }

    /**
     * Implements an in-place sorting of array of {@code Person} instances according to length of {@code password} field.
     * @param people the array to be sorted.
     * */
    public static void sortByPasswordLength(Person[] people) {
        Sort.sort(people, new PersonComparatorByPasswordLength());
    }
    /**
     * Implements an in-place sorting of array of {@code Person} instances first by length
     * of {@code password} field and then by alphabetic order of their {@code name}.
     * @param people the array to be sorted.
     * */
    public static void sortByPasswordLengthAndNickname(Person[] people) {
        Sort.sort(people, new PersonComparatorByPasswordLengthAndNickname());
    }
}
