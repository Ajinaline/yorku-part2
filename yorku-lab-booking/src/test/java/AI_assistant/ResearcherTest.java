package AI_assistant;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.yorku.users.Researcher;

class ResearcherTest {

    @Test
    void researcherConstructorSetsFieldsCorrectly() {
        Researcher res = new Researcher("research.lead@yorku.ca", "Res_Pass_2026!", "R-505");
        assertNotNull(res);
        assertEquals("research.lead@yorku.ca", res.getEmail());
    }

    @Test
    void researcherIdIsStoredCorrectly() {
        Researcher res = new Researcher("e", "p", "RES-ID-123");
        assertEquals("RES-ID-123", res.getIdNumber());
    }

    @Test
    void researcherIsInstanceOfUser() {
        assertTrue(new Researcher("e", "p", "i") instanceof com.yorku.users.User);
    }
}