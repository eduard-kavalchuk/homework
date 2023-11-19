package home_work_5.helpers;

import home_work_5.Person;

public class PersonComparatorByPasswordLengthAndNickname implements IComparator<Person> {
    public int compare(Person o1, Person o2) {
        PersonComparatorByPasswordLength cmp = new PersonComparatorByPasswordLength();
        int byPasswordLength = cmp.compare(o1, o2);
        if (byPasswordLength == 0)
            return o1.getName().compareTo(o2.getName());
        return byPasswordLength;
    }
}
