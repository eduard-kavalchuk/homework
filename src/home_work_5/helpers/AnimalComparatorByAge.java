package home_work_5.helpers;

import home_work_5.Animal;

public class AnimalComparatorByAge implements IComparator<Animal> {
    /**
     * Implements comparison of two {@code Animals} by their age.
     * @param  o1 the first {@code Animal} to compare
     * @param  o2 the second {@code Animal} to compare
     * @return the value {@code 0} if {@code o1.age == o2.age};
     *         a value less than {@code 0} if {@code o1.age < o2.age}; and
     *         a value greater than {@code 0} if {@code o1.age > o2.age}
     * */
    public int compare(Animal o1, Animal o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
