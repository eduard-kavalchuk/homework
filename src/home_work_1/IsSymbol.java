package home_work_1;

public class IsSymbol {
    public static void main(String args[]) {
        if ((args.length != 1) || (args[0].length() != 1)) {
            System.err.println("Usage: IsSymbol character");
            return;
        }
        System.out.println("Input character is an alphabetic: " + isSymbol(args[0]));
    }

    public static boolean isSymbol(String c) {
        if (c.length() != 1)
            return false;
        return Character.isAlphabetic(c.charAt(0));
    }
}
