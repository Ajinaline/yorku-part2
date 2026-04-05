package AI_assistant;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.yorku.users.Student;

class StudentTest {

    @Test
    void constructorSetsStudentFieldsCorrectly() {
        Student student = new Student("student.user@yorku.ca", "Secure_Pass_99!", "219555444");
        assertNotNull(student);
        assertEquals("student.user@yorku.ca", student.getEmail());
    }

    @Test
    void getHourlyRateReturnsCorrectValueForStudent() {
        // Verifying the hardcoded $10 rate
        Student student = new Student("test@yorku.ca", "p", "i");
        assertEquals(10.0, student.getHourlyRate());
    }

    @Test
    void studentIsInstanceOfUser() {
        assertTrue(new Student("e", "p", "i") instanceof com.yorku.users.User);
    }
}