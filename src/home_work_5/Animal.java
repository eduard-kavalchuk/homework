package home_work_5;

import home_work_5.helpers.*;

/**
 * DTO class Animal.
 * Since DTO classes are designed to transfer immutable objects all fields of this class are declared {@code final}.
 * Setters are not implemented since field values are assigned once during constructor call.
 * To create specific Person instances use PersonFactory factory class.
 * */
public class Animal {
    private final int age;
    private final String nick;
    public Animal(int age, String nick) {
        this.age = age;
        this.nick = nick;
    }
    public int getAge() {
        return age;
    }
    public String getNick() {
        return nick;
    }

    /**
     * Implements an in-place sorting of array of {@code Animal} instances according to length of {@code age} field.
     * @param animals the array to be sorted.
     * */
    public static void sortByAge(Animal[] animals) {
        Sort.sort(animals, new AnimalComparatorByAge());
    }

    /**
     * Implements an in-place sorting of array of {@code Animal} instances first by length
     * of {@code age} field and then by alphabetic order of their {@code nick}.
     * @param animals the array to be sorted.
     * */
    public static void sortByAgeAndNickname(Animal[] animals) {
        Sort.sort(animals, new AnimalComparatorByAgeAndNickname());
    }
}
