package home_work_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneNumberTest {
    @Test
    @DisplayName("Phone number")
    public void phoneNumber() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String phoneNumber =  PhoneNumber.createPhoneNumber(array);
        assertEquals("(123) 456-7890", phoneNumber);
    }
}
