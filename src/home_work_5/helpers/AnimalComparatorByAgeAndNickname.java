package home_work_5.helpers;

import home_work_5.Animal;

public class AnimalComparatorByAgeAndNickname implements IComparator<Animal> {
    /**
     * Implements comparison of two {@code Animals} by age. If ages are equal
     * makes a further comparison by nicknames according to alphabetic order.
     * @param  o1 the first {@code Animal} to compare
     * @param  o2 the second {@code Animal} to compare
     * @return the value {@code 0} if {@code o1.age == o2.age};
     *         a value less than {@code 0} if {@code o1.age < o2.age}; and
     *         a value greater than {@code 0} if {@code o1.age > o2.age}
     *         If ages are equal returns {@code 0} if nicknames are the same; a value less than
     *         {@code 0} if {@code o1.nick} is lexicographically less than {@code o2.nick};
     *         a value greater than {@code 0} if {@code o1.nick} is lexicographically
     *         greater than {@code o2.nick}.
     * */
    public int compare(Animal o1, Animal o2) {
        AnimalComparatorByAge cmp = new AnimalComparatorByAge();
        int byAge = cmp.compare(o1, o2);
        if (byAge == 0)
            return o1.getNick().compareTo(o2.getNick());
        return byAge;
    }
}
