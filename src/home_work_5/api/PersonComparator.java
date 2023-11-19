package home_work_5.api;

import home_work_5.Person;

public interface PersonComparator {
    default int byPasswordLength(Person o1, Person o2) {
        return Integer.compare(o1.getPassword().length(), o2.getPassword().length());
    }
    default int byPasswordLengthAndNickname(Person o1, Person o2) {
        int byPasswordLength = byPasswordLength(o1, o2);
        if (byPasswordLength == 0)
            return o1.getName().compareTo(o2.getName());
        return byPasswordLength;
    }
}
