package home_work_1;

public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0 || year % 100 == 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        }
        return true;
    }
    public static void main(String args[]) {
        int year;

        // Check that exactly one argument has been provided
        if (args.length != 1) {
            System.err.println("Usage: LeapYear integer");
            return;
        }

        // Check that an argument has INTEGER type
        try {
            year = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Illegal argument: " + args[0]);
            System.err.println("Argument must have INTEGER type.");
            return;
        }

        System.out.println("Year " + year + " is a leap year: " + isLeapYear(year));
    }
}
