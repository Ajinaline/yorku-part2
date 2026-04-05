package human_tests;

import com.yorku.users.Student;
import com.yorku.users.User;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentTest {
    // 1
    @Test
    void testStudentInitialization() {
        // Making sure the student object is created with correct data
        Student s = new Student("student.test@yorku.ca", "YorkU_Secure_99!", "219555666");
        assertNotNull(s);
    }
    // 2
    @Test
    void testStudentHourlyRate() {
        // Check the student rate is hardcoded to 10.0
        Student s = new Student("user@yorku.ca", "p", "i");
        assertEquals(10.0, s.getHourlyRate());
    }
    // 3
    @Test
    void testEmailStorage() {
        // Testing email persistence in the student object
        Student s = new Student("my.academic.email@yorku.ca", "pass123", "id-01");
        assertEquals("my.academic.email@yorku.ca", s.getEmail());
    }
    // 4
    @Test
    void testPasswordStorage() {
        // Making sure the password stays correct after setup
        Student s = new Student("e", "Student_Secret_Password_2026", "i");
        assertEquals("Student_Secret_Password_2026", s.getPassword());
    }
    // 5
    @Test
    void testIdNumberStorage() {
        // Checking ID number storage
        Student s = new Student("e", "p", "STUDENT-ID-001");
        assertEquals("STUDENT-ID-001", s.getIdNumber());
    }
    // 6
    @Test
    void testInstanceOfUser() {
        // Confirming inheritance from parent User class
        assertTrue(new Student("e", "p", "i") instanceof User);
    }
    // 7
    @Test
    void testClassIdentity() {
        // Checking that the object is specifically a Student
        assertTrue(new Student("e", "p", "i") instanceof Student);
    }
    // 8
    @Test
    void testToStringResponse() {
        // Making sure the toString method doesn't return null
        assertNotNull(new Student("e", "p", "i").toString());
    }
    // 9
    @Test
    void testObjectDifference() {
        // Making sure two student objects are not the same instance
        assertNotSame(new Student("e", "p", "1"), new Student("e", "p", "1"));
    }
    // 10
    @Test
    void testEmptyEmailHandling() {
        // Checking how empty strings are stored
        Student s = new Student("", "", "");
        assertEquals("", s.getEmail());
    }
}