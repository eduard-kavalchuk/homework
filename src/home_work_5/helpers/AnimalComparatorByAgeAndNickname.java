package home_work_5.helpers;

import home_work_5.Animal;

public class AnimalComparatorByAgeAndNickname implements IComparator<Animal> {
    public int compare(Animal o1, Animal o2) {
        AnimalComparatorByAge cmp = new AnimalComparatorByAge();
        int byAge = cmp.compare(o1, o2);
        if (byAge == 0)
            return o1.getNick().compareTo(o2.getNick());
        return byAge;
    }
}
