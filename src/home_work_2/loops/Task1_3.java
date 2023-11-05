package home_work_2.loops;

class Task1_3 {
    private static boolean checkInput(String[] args) {
        if (args.length != 2)
            return false;

        try {
            Double.parseDouble(args[0]);
            if (Integer.parseInt(args[1]) <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static double power(double a, int b) {
        double result = a;
        for (int i = 1; i < b; i++)
            result *= a;
        return result;
    }
    
    public static void main(String[] args) {
        if (!checkInput(args)) {
            System.out.println("Usage: Task1_3 <double> <positive integer>.");
            return;
        }
        
        double a = Double.parseDouble(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(args[0] + " ^ " + args[1] + " = " + power(a, b));
    }
}
