package home_work_1;

public class FindOdd {
    public static void isOdd(int number) {
        if(number % 2 == 0)
            System.out.println("Number " + number + " is even.");
        else
            System.out.println("Number " + number + " is odd.");
    }

    public static void main(String args[]) {
        int arg;

        if(args.length != 1) {
            System.out.println("Usage: FindOdd arg");
            return;
        }

        try {
            arg = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Illegal argument: " + args[0]);
            System.err.println("Argument must have INTEGER type.");
            return;
        }

        isOdd(arg);
    }
}
