package home_work_1;

public class Divider {
    public static boolean IsDivider(int divider, int divisor) {
        return divider % divisor == 0 ? true : false;
    }

    public static void main(String args[]) {
        int inputArgs[] = new int[2];
        boolean result;

        // Check that exactly two arguments have been provided
        if (args.length != 2) {
            System.err.println("Usage: IsDivider divider divisor");
            return;
        }

        // Check that all arguments have INTEGER type
        for(int i = 0; i < args.length; i++) {
            try {
                inputArgs[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.err.println("Illegal argument: " + args[i]);
                System.err.println("All arguments must have INTEGER type");
                return;
            }
        }

        result = IsDivider(inputArgs[0], inputArgs[1]);
        System.out.println(args[0] + " can be divided by " + args[1] + ": " + result);
    }
}
