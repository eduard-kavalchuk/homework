package home_work_5;

import home_work_5.helpers.PersonComparatorByPasswordLength;
import home_work_5.helpers.PersonComparatorByPasswordLengthAndNickname;
import home_work_5.helpers.Sort;

import java.util.Objects;

/**
 * DTO class Person.
 * Since DTO classes are designed to transfer immutable objects all fields of this class are declared {@code final}.
 * Setters are not implemented since field values are assigned once during constructor call.
 * To create specific Person instances use PersonFactory factory class.
 * */
public class Person implements Comparable<Person> {
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

    /**
     * Redefine {@code equals} method
     * @param other instance to be compared with
     * @return {@code true} if {@code other} is the same instance and {@code false} otherwise
     * */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof Person person)) {
            return false;
        }
        return person.name.equals(this.name) && person.nick.equals(this.nick) && person.password.equals(this.password);
    }

    /**
     * @return a hash value of the sequence of object's fields
     * */
    @Override
    public int hashCode() {
        return Objects.hash(name, nick, password);
    }

    /**
     * Implements {@code Comparable} interface
     * */
    public int compareTo(Person o) {
        if (equals(o)) {
            return 0;
        }
        else if(hashCode() > o.hashCode()) {
            return 1;
        }
        else return -1;
    }
}
