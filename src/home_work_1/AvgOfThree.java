package home_work_1;

public class AvgOfThree {
    public static int GetAvg(int args[]) {
        int temp;
        // Bubble sort the array and return a middle value
        for (int i = 0; i < args.length; i++) {
            for (int j = i+1; j < args.length; j++) {
                if(args[i] > args[j]) {
                    temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                }
            }
        }
        return args[1];
    }

    public static void main(String args[]) {
        int inputArgs[] = new int[3];
        int avg;

        // Check that exactly three arguments have been provided
        if (args.length != 3) {
            System.err.println("Usage: AvgOfThree int1 int2 int3");
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

        avg = GetAvg(inputArgs);
        System.out.println("Average of three: " + avg);
    }
}
