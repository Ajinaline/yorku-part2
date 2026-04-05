package human_tests;

import com.yorku.users.User;
import com.yorku.users.Guest;
import com.yorku.users.Student;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GuestTest {
    // 1
    @Test
    void testGuestInitialization() {
        // Checking guest with external email data
        Guest g = new Guest("visitor.user@gmail.com", "GuestPass123!", "G-2026");
        assertNotNull(g);
    }
    // 2
    @Test
    void testGuestHourlyRate() {
        // Checking the guest rate is specifically 30.0
        Guest g = new Guest("e", "p", "i");
        assertEquals(30.0, g.getHourlyRate());
    }
    // 3
    @Test
    void testEmailDataStorage() {
        // Checking the guest email
        Guest g = new Guest("external.test@yorku.ca", "p", "i");
        assertEquals("external.test@yorku.ca", g.getEmail());
    }
    // 4
    @Test
    void testPasswordDataStorage() {
        // Checking the guest password
        Guest g = new Guest("e", "Visitor_Account_Pass_99!", "i");
        assertEquals("Visitor_Account_Pass_99!", g.getPassword());
    }
    // 5
    @Test
    void testIdNumberDataStorage() {
        // Checking visitor ID format
        Guest g = new Guest("e", "p", "GUEST-ID-01");
        assertEquals("GUEST-ID-01", g.getIdNumber());
    }
    // 6
    @Test
    void testInheritanceFromUser() {
        // Making sure Guest is a child of the User class
        assertTrue(new Guest("e", "p", "i") instanceof User);
    }
    // 7
    @Test
    void testSpecificGuestType() {
        // Making sure the class identity is specifically Guest
        assertEquals(Guest.class, new Guest("e", "p", "i").getClass());
    }
    // 8
    @Test
    void testGuestInequality() {
        // Checking a Guest object is not seen as a Student object
        Guest g = new Guest("e", "p", "i");
        assertNotEquals(g, new Student("e", "p", "i"));
    }
    // 9
    @Test
    void testObjectPresence() {
        // General check for guest initialization
        assertNotNull(new Guest("test@email.com", "p", "id"));
    }
    // 10
    @Test
    void testMultipleGuestUniqueness() {
        // Two guest objects created separately are not the same instance
        Guest g1 = new Guest("a@y.ca", "p", "1");
        Guest g2 = new Guest("a@y.ca", "p", "1");
        assertNotSame(g1, g2);
    }
}