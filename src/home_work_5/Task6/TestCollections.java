package home_work_5.Task6;

public class TestCollections {
    public static void main(String[] args) {
        ArrayListCollection alc = new ArrayListCollection(100);
        alc.calculateTimes();

        LinkedListCollection llc = new LinkedListCollection(100);
        llc.calculateTimes();

        HashSetCollection hsc = new HashSetCollection(100);
        hsc.calculateTimes();

        TreeSetCollection tsc = new TreeSetCollection(100);
        tsc.calculateTimes();
    }
}
