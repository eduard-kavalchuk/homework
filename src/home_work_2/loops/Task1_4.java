package home_work_2.loops;

class Task1_4 {
    private static boolean isPositiveOverflowCandidate(Long number, Long divisor) {
        if (
            (( divisor > 0 ) && ( number > Long.MAX_VALUE / divisor )) ||
            (( divisor < 0 ) && ( number < 0 && number < Long.MAX_VALUE / divisor ))
        ) 
            return true;
        return false;
    }

    private static boolean isNegativeOverflowCandidate(Long number, Long divisor) {
        if (( divisor < 0 ) && ( number > 0 && number > Long.MIN_VALUE / divisor ))
            return true;
        return false;
    }

    private static long parseInput(String[] args) throws Exception {
        if (args.length != 1)
            throw new Exception();
        return Long.parseLong(args[0]);
    }
    public static void main(String[] args) {
        Long a = (long) 1;
        Long divisor;

        try {
            divisor = parseInput(args);
        } catch (Exception e) {
            System.out.println("Usage: Task1_4 <integer>.");
            return;
        }

        for (;;) {
            if (isPositiveOverflowCandidate(a, divisor) || isNegativeOverflowCandidate(a, divisor)) {
                System.out.println("Значение перед переполнением: " + a);
                System.out.println("Значение после переполнения:  " + a * divisor);
                return;
            }
            a *= divisor;
        }
    }
}
