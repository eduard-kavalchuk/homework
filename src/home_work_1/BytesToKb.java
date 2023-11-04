package home_work_1;

public class BytesToKb {
    public static float Bytes2Kb(int bytes) {
        return bytes / 1024f;
    }
    public static void main(String args[]) {
        int inputArg;

        // Check that exactly three arguments have been provided
        if (args.length != 1) {
            System.err.println("Usage: AvgOfThree int");
            return;
        }

        // Check that all arguments have INTEGER type
        try {
            inputArg = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Illegal argument: " + args[0]);
            System.err.println("Argument must have INTEGER type.");
            return;
        }

        System.out.println("Bytes: " + inputArg);
        System.out.println("Kilobytes: " + Bytes2Kb(inputArg));
    }
}
