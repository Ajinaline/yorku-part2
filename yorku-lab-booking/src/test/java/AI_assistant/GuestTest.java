package AI_assistant;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.yorku.users.Guest;

class GuestTest {

    @Test
    void guestConstructorSetsFieldsCorrectly() {
        Guest guest = new Guest("external.visitor@gmail.com", "Guest_Pass_123!", "G-001");
        assertNotNull(guest);
        assertEquals("external.visitor@gmail.com", guest.getEmail());
    }

    @Test
    void guestPasswordIsStoredCorrectly() {
        Guest guest = new Guest("e", "Visitor_Access_2026", "i");
        assertEquals("Visitor_Access_2026", guest.getPassword());
    }

    @Test
    void guestClassIsIdentifiedCorrectly() {
        Guest guest = new Guest("e", "p", "i");
        assertEquals("Guest", guest.getClass().getSimpleName());
    }
}