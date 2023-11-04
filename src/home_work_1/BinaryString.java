package home_work_1;

class BinaryString {
    public static String toggleBits(String input) {
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            result += input.charAt(i) == '0' ? "1" : "0";
        }

        return result;
    }

    public static String toUnsignedBinaryString(byte number) {
        int binaryNum[] = new int[8];
        String str = "";

        // Convert byte to binary representation and store it in an array. MSB is at index 0
        for (int i = 7; number > 0; ) {
            binaryNum[i--] = number % 2;
            number /= 2;
        }

        // Convert array to string
        for (int i: binaryNum) {
            str += Integer.toString(i);
        }

        return str;
    }

    public static String toTwosComplementString(byte number) {
        String s;

        // Absolute value of -128 overflows the byte so it should be handled separately
        if (number == -128)
            return "10000000";

        s = toUnsignedBinaryString((byte) Math.abs(number));

        /**
         * Implementation of conversion algorithm from positive binaries to 2's complement:
         * https://en.wikipedia.org/wiki/Two%27s_complement
         * See paragraph "Working from LSB towards MSB"
         */
        for (int i = 7; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                s = toggleBits(s.substring(0, i)) + "1" + s.substring(i + 1);
                break;
            }
        }

        return s;
    }

    public static String toBinaryString(byte number) {
        if (number >= 0)
            return toUnsignedBinaryString(number);
        return toTwosComplementString(number);
    }
    public static void main(String args[]) {
        byte inputByte;

        if (args.length != 1) {
            System.err.println("Usage: BinaryString byte");
            return;
        }

        try {
            inputByte = Byte.parseByte(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Illegal argument: " + args[0]);
            System.err.println("Argument must have a BYTE type " +
                               "(integer in [" + Byte.MIN_VALUE + ", " + Byte.MAX_VALUE + "] range)."
            );
            return;
        }

        System.out.println(toBinaryString(inputByte));
    }
}
