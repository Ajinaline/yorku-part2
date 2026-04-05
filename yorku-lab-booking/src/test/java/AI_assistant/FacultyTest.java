package AI_assistant;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.yorku.users.Faculty;

class FacultyTest {

    @Test
    void constructorSetsFacultyFieldsCorrectly() {
        Faculty faculty = new Faculty("prof.test@yorku.ca", "Fac_Secure_2026!", "F-999");
        assertEquals("F-999", faculty.getIdNumber());
        assertEquals("prof.test@yorku.ca", faculty.getEmail());
    }

    @Test
    void getHourlyRateReturnsCorrectValueForFaculty() {
        Faculty faculty = new Faculty("e", "p", "i");
        assertEquals(15.0, faculty.getHourlyRate());
    }

    @Test
    void facultyPasswordIsStoredCorrectly() {
        Faculty faculty = new Faculty("e", "Strong_Faculty_Pass!", "i");
        assertEquals("Strong_Faculty_Pass!", faculty.getPassword());
    }
}