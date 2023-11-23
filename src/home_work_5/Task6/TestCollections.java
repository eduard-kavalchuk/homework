package home_work_5.Task6;

/**
 * Класс предназначенный для тестирования операций с коллекциями
 * */
public class TestCollections {
    public static void main(String[] args) {
        // Применяем полиморфизм
        PeopleCollectionsManipulator alc = new ArrayListCollection(1000);
        alc.calculateTimes();

        PeopleCollectionsManipulator llc = new LinkedListCollection(1000);
        llc.calculateTimes();

        PeopleCollectionsManipulator hsc = new HashSetCollection(1000);
        hsc.calculateTimes();

        PeopleCollectionsManipulator tsc = new TreeSetCollection(1000);
        tsc.calculateTimes();
    }
}
