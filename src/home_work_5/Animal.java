package home_work_5;

import home_work_5.helpers.*;

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
    public static void sortByAge(Animal[] animals) {
        Sort.sort(animals, new AnimalComparatorByAge());
    }
    public static void sortByAgeAndNickname(Animal[] animals) {
        Sort.sort(animals, new AnimalComparatorByAgeAndNickname());
    }
}
