package home_work_5.Task6;

import home_work_5.Person;
import home_work_5.PersonFactory;

public abstract class PeopleCollectionsManipulator {
    public final Person[] people;
    public PeopleCollectionsManipulator(int collectionSize) {
        people = new Person[collectionSize];
        for (int i = 0; i < collectionSize; i++)
            people[i] = PersonFactory.createWithRandomLatinName("nickname", "password");
    }
    public abstract void calculateTimes();
}
