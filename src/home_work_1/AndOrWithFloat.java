package home_work_1;

public class AndOrWithFloat {
    public static void main(String args[]) {
        final float magicFloat = 42.5f;
        byte inputByteArg;

        // Check that exactly one argument has been provided
        if (args.length != 1) {
            System.err.println("Usage: AndOrWithBytes argument.");
            return;
        }

        // Check that the argument has a BYTE type
        try {
            inputByteArg = Byte.parseByte(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Illegal argument: " + args[0]);
            System.err.println("An argument must have BYTE type " +
                                "(integer in [" + Byte.MIN_VALUE + ", " + Byte.MAX_VALUE + "] range)."
            );
            return;
        }

        // Throws "bad operand types for binary operator '|' " compilation error because 
        // bitwise operators can be applied only to the integer types, i. e. long, int, short, char, and byte.
        // int i = inputByteArg | magicFloat;
    }
}
