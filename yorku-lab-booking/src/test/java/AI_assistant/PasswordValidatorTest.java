package AI_assistant;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.yorku.users.PasswordValidator;

class PasswordValidatorTest {

    @Test
    void isStrongReturnsTrueForValidPassword() {
        assertTrue(PasswordValidator.isValid("YorkU_Student_2026!"));
    }

    @Test
    void isStrongReturnsFalseForShortPassword() {
        assertFalse(PasswordValidator.isValid("Ab1!"));
    }

    @Test
    void isStrongReturnsFalseForMissingDigit() {
        assertFalse(PasswordValidator.isValid("YorkU_Student!"));
    }

    @Test
    void isStrongReturnsFalseForMissingSpecialChar() {
        assertFalse(PasswordValidator.isValid("YorkUStudent2026"));
    }

    @Test
    void isStrongThrowsExceptionOnNullInput() {
        assertThrows(NullPointerException.class, () -> PasswordValidator.isValid(null));
    }
}