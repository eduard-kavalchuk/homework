package home_work_2.loops;

class Task1_2 {
    public static String calculate(String input) {
        if (input.length() == 1)
            return input;

        String[] substrings = input.split("");
        String outputString = substrings[0];
        long total = 1;

        for (int i = 1; i < substrings.length; i++) {
            total *= Long.parseLong(substrings[i]);
            outputString += " * " + substrings[i];
        }

        return outputString + " = " + total;
    }

    private static boolean isInteger(String s)
    {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {}

        try {
            Double.parseDouble(s);
            System.out.println("Введено не целое число");
            return false;
        } catch (NumberFormatException e) {}

        System.out.println("Введено не число");
        return false;
    }

    private static boolean checkInput(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: Task1_2 <long>.");
            return false;
        }

        return isInteger(args[0]);
    }

    public static void main(String[] args) {
        if(checkInput(args))
            System.out.println(calculate(args[0]));
    }
}
