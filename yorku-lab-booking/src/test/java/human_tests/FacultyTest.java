package human_tests;

import com.yorku.users.User;
import com.yorku.users.Faculty;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FacultyTest {
    // 1
    @Test
    void testFacultyInitialization() {
        // Checking creation of faculty object
        Faculty f = new Faculty("faculty.member@yorku.ca", "Faculty_Secure_123!", "F-999");
        assertNotNull(f);
    }
    // 2
    @Test
    void testFacultyHourlyRate() {
        // Checking the faculty rate is exactly 15.0
        Faculty f = new Faculty("e", "p", "i");
        assertEquals(15.0, f.getHourlyRate());
    }
    // 3
    @Test
    void testEmailPersistence() {
        // Checking email storage
        Faculty f = new Faculty("dept.head@yorku.ca", "p", "i");
        assertEquals("dept.head@yorku.ca", f.getEmail());
    }
    // 4
    @Test
    void testPasswordPersistence() {
        // Checking password storage
        Faculty f = new Faculty("e", "Faculty_Account_Password_2026", "i");
        assertEquals("Faculty_Account_Password_2026", f.getPassword());
    }
    // 5
    @Test
    void testIdPersistence() {
        // Checking the faculty ID format
        Faculty f = new Faculty("e", "p", "FAC-ID-001");
        assertEquals("FAC-ID-001", f.getIdNumber());
    }
    // 6
    @Test
    void testInheritance() {
        // Checking if Faculty is a child of User
        assertTrue(new Faculty("e", "p", "i") instanceof User);
    }
    // 7
    @Test
    void testSpecificClassType() {
        // Checking class identity
        assertTrue(new Faculty("e", "p", "i") instanceof Faculty);
    }
    // 8
    @Test
    void testClassSimpleName() {
        // Testing class naming
        assertEquals("Faculty", new Faculty("e", "p", "i").getClass().getSimpleName());
    }
    // 9
    @Test
    void testEmailNotEmpty() {
        // Simple check to make sure email isn't empty
        Faculty f = new Faculty("test.faculty@yorku.ca", "p", "i");
        assertFalse(f.getEmail().isEmpty());
    }
    // 10
    @Test
    void testObjectPresence() {
        // General check
        assertNotNull(new Faculty("e", "p", "i"));
    }
}