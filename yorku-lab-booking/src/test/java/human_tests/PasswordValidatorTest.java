package human_tests;

import com.yorku.users.PasswordValidator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {
    // 1
    @Test
    void testStandardValidPassword() {
        // Checking a strong password that meets all requirements
        assertTrue(PasswordValidator.isValid("YorkU_Student_2026!"));
    }
    // 2
    @Test
    void testShortPasswordFailure() {
        // Should fail because it is only 5 characters
        assertFalse(PasswordValidator.isValid("Yrk1!"));
    }
    // 3
    @Test
    void testNoUpperCaseFailure() {
        // Should fail because there is no capital letter
        assertFalse(PasswordValidator.isValid("yorku_user_2026!"));
    }
    // 4
    @Test
    void testNoLowerCaseFailure() {
        // Should fail because it is all uppercase
        assertFalse(PasswordValidator.isValid("YORKU_USER_2026!"));
    }
    // 5
    @Test
    void testNoDigitFailure() {
        // Fails because there are no numbers
        assertFalse(PasswordValidator.isValid("YorkU_User_Test!"));
    }
    // 6
    @Test
    void testNoSpecialCharFailure() {
        // Fails because there is no special symbol
        assertFalse(PasswordValidator.isValid("YorkUUser2026"));
    }
    // 7
    @Test
    void testEmptyInput() {
        // An empty string is not a valid password
        assertFalse(PasswordValidator.isValid(""));
    }
    // 8
    @Test
    void testMinimumLengthBoundary() {
        // Testing exactly 8 characters
        assertTrue(PasswordValidator.isValid("Abc1234!"));
    }
    // 9
    @Test
    void testVeryLongValidPassword() {
        // Checking that it works with long strings
        assertTrue(PasswordValidator.isValid("Secure_Account_For_YorkU_Student_2026!"));
    }
    // 10
    @Test
    void testNullPointerHandling() {
        // Making sure the validator throws an exception on null
        assertThrows(NullPointerException.class, () -> PasswordValidator.isValid(null));
    }
}