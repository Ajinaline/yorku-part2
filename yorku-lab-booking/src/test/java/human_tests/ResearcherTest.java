package human_tests;

import com.yorku.users.Researcher;
import com.yorku.users.User;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ResearcherTest {
    // 1
    @Test
    void testResearcherInitialization() {
        // Creating researcher object with data
        Researcher r = new Researcher("research.lead@yorku.ca", "Res_Pass_2026!", "R-101");
        assertNotNull(r);
    }
    // 2
    @Test
    void testResearcherHourlyRate() {
        // Checking the researcher rate is 20.0
        Researcher r = new Researcher("e", "p", "i");
        assertEquals(20.0, r.getHourlyRate());
    }
    // 3
    @Test
    void testEmailStorage() {
        // Making sure the email is stored correctly
        Researcher r = new Researcher("academic.lab@yorku.ca", "p", "i");
        assertEquals("academic.lab@yorku.ca", r.getEmail());
    }
    // 4
    @Test
    void testPasswordStorage() {
        // Making sure the password is stored correctly
        Researcher r = new Researcher("e", "Researcher_Secret_99!", "i");
        assertEquals("Researcher_Secret_99!", r.getPassword());
    }
    // 5
    @Test
    void testIdStorage() {
        // Making sure the researcher ID format is stored correctly
        Researcher r = new Researcher("e", "p", "ID-RESEARCH-55");
        assertEquals("ID-RESEARCH-55", r.getIdNumber());
    }
    // 6
    @Test
    void testUserParentInheritance() {
        // Checking inheritance from User
        assertTrue(new Researcher("e", "p", "i") instanceof User);
    }
    // 7
    @Test
    void testResearcherClassIdentity() {
        // Checking specific class type
        assertTrue(new Researcher("e", "p", "i") instanceof Researcher);
    }
    // 8
    @Test
    void testNullEmailCheck() {
        // Testing null handling in the parent constructor
        Researcher r = new Researcher(null, "pass", "id");
        assertNull(r.getEmail());
    }
    // 9
    @Test
    void testHashCodeValue() {
        // Making sure the object has a hash code
        assertNotEquals(0, new Researcher("e", "p", "i").hashCode());
    }
    // 10
    @Test
    void testObjectNotNull() {
        // Simple check for object creation
        assertNotNull(new Researcher("test", "test", "test"));
    }
}