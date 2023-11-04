package home_work_1;

public class PhoneNumber {
    public static String createPhoneNumber(int[] arrayOfNumbers) {
        long phoneNumber = 0;

        if (arrayOfNumbers.length != 10) {
            return "Error: input array must contain exactly 10 elements";
        }

        for (int i: arrayOfNumbers) {
            if (i < 0 || i > 9)
                return "Error: input array must contain only digits";
        }

        // Convert array to long
        for (int i = 0; i < arrayOfNumbers.length; i++)
            phoneNumber = phoneNumber * 10 + arrayOfNumbers[i];

        // https://stackoverflow.com/questions/5114762/how-do-format-a-phone-number-as-a-string-in-java
        return String.valueOf(phoneNumber).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    }
    public static void main(String args[]) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        System.out.println(createPhoneNumber(array));
    }
}
