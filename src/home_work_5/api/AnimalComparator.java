package home_work_5.api;

import home_work_5.Animal;

public interface AnimalComparator {
    default int byAge(Animal o1, Animal o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
    default int byPasswordLengthAndNickname(Animal o1, Animal o2) {
        int byAge= byAge(o1, o2);
        if (byAge == 0)
            return o1.getNick().compareTo(o2.getNick());
        return byAge;
    }
}
