package home_work_1;

class AndOrWithBytes {
    public static void main(String args[]) {
        byte inputByteArgs[] = new byte[2];

        // Check that exactly two arguments have been provided
        if (args.length != 2) {
            System.err.println("Usage: AndOrWithBytes byte1 byte2.");
            return;
        }

        // Check that both arguments have a BYTE type
        for(int i = 0; i < args.length; i++) {
            try {
                inputByteArgs[i] = Byte.parseByte(args[i]);
            } catch (NumberFormatException e) {
                System.err.println("Illegal argument: " + args[i]);
                System.err.println("Both arguments must have BYTE type " +
                                   "(integer in [" + Byte.MIN_VALUE + ", " + Byte.MAX_VALUE + "] range)."
                );
                return;
            }
        }

        PrintResults(inputByteArgs, "AND");
        System.out.println("\n");
        PrintResults(inputByteArgs, "OR");
    }

    /**
     * Calculates and prints a result of a bitwise operation between two bytes.
     * Java uses an encoding known as 2's complement,
     * which means that negative numbers are represented by inverting (changing 1’s to 0’s and vice versa) 
     * all of the bits in a value, then adding 1 to the result.
     *  For example, –42 is represented by inverting all of the bits in 42, or 00101010, which yields 11010101, 
     * then adding 1, which results in 11010110, or –42. To decode a negative number, first invert all of the bits, 
     * then add 1. For example, –42, or 11010110 inverted, yields 00101001, or 41, so when you add 1 you get 42.
     */
    public static void PrintResults(byte args[], String operation) {
        byte result;

        if (args.length != 2) {
            System.err.println("PrintResults: array *args* must contain two elements.");
            return;
        }

        if (operation.compareToIgnoreCase("AND") == 0) {
            result = (byte) (args[0] & args[1]);
        }
        else if(operation.compareToIgnoreCase("OR") == 0){
            result = (byte) (args[0] | args[1]);
        }
        else {
            System.out.println("Operation " + operation + " is not supported.");
            return;
        }

        System.out.println("Decimal format: " + args[0] + " " + operation + " " + args[1] + " = " + result);
        System.out.println("Binary format:");

        /**
         * (args[0] & 0xFF) means expand 8-bit args[0] to 32-bit integer and apply a 32-bit 0xFF mask 
         * to replace 1's in leading 24 bits in case if args[0] is negative. The mask has no effect if 
         * args[0] is non-negative.
         */
        String s1 = String.format(
            "%8s", 
            Integer.toBinaryString(args[0] & 0xFF)
        ).replace(' ', '0');

        String s2 = String.format(
            "%8s", 
            Integer.toBinaryString(args[1] & 0xFF)
        ).replace(' ', '0');

        String s3 = String.format(
            "%8s", 
            Integer.toBinaryString(result & 0xFF)
        ).replace(' ', '0');

        System.out.println(s1 + " " + operation);
        System.out.println(s2);
        System.out.println("--------");
        System.out.println(s3);
    }
}
