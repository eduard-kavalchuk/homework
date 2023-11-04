package home_work_1;

import java.util.ArrayList;
import java.util.Collection;

public class Task5 {
    public static boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation ? true : false;
    }
    public static void main(String args[]) {
        Collection<Boolean> collection = new ArrayList<Boolean>();
        
        collection.add(true);
        collection.add(false);

        for (Boolean weekday: collection)
            for (Boolean vacation: collection) {
                System.out.println(
                    "weekday: " + weekday + 
                    ", vacation: " + vacation + 
                    " => sleep: " + sleepIn(weekday, vacation)
                );
            }
    }
}
