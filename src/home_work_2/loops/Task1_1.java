package home_work_2.loops;

class Task1_1 {
    private static long total = 1;

    public static String useLoops(long input) throws ArithmeticException {
        long total = 1;
        String output = "1";

        if (input <= 1)
            return String.valueOf(input);

        for (int i = 2; i <= input; i++) {
            total = Math.multiplyExact(total, i);
            output += " * " + String.valueOf(i);
        }

        return output + " = " + String.valueOf(total); 
    }

    public static String useRecursion(long input) {  
        return _useRecursion(input) + " = " + String.valueOf(Task1_1.total);
    }

    public static String _useRecursion(long input) throws ArithmeticException {
        if (input <= 1) {
            return String.valueOf(input);
        }
        Task1_1.total = Math.multiplyExact(Task1_1.total, input);
        return _useRecursion(input - 1) + " * " + String.valueOf(input);
    }
    public static void main(String[] args) {
        Long inputNumber;

        if (args.length != 1) {
            System.err.println("Usage: Task1_1 long.");
            return;
        }

        try {
            inputNumber = Long.parseLong(args[0]);
            if (inputNumber < 0) {
                System.out.println("Input number must be a positive integer.");
                return;
            }
        } catch (NumberFormatException e) {
            System.err.println("Illegal argument: " + args[0]);
            System.err.println("Argument must be a positive integer, maximum long.");
            return;
        }

        // Task 1.1.1
        try {
            System.out.println(Task1_1.useLoops(inputNumber));
        } catch (ArithmeticException e) {
            System.out.println("Input number is too big, long overflow happened.");
        }

        // Task 1.1.2
        try {
            System.out.println(Task1_1.useRecursion(inputNumber));
        } catch (ArithmeticException e) {
            System.out.println("Input number is too big, long overflow happened.");
        }
    }
}
