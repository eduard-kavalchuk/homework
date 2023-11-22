package home_work_5.Task6;

/**
 * Класс предназначенный для тестирования операций с коллекциями
 * */
public class TestCollections {
    public static void main(String[] args) {
        ArrayListCollection alc = new ArrayListCollection(1000);
        alc.calculateTimes();

        LinkedListCollection llc = new LinkedListCollection(1000);
        llc.calculateTimes();

        HashSetCollection hsc = new HashSetCollection(1000);
        hsc.calculateTimes();

       TreeSetCollection tsc = new TreeSetCollection(1000);
       tsc.calculateTimes();
    }
}
