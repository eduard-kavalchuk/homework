package home_work_5.api;

import home_work_5.Animal;

public class AnimalComparatorByAge implements IComparator<Animal> {
    public int compare(Animal o1, Animal o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
