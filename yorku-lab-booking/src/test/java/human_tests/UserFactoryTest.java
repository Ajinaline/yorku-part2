package human_tests;

import com.yorku.users.Faculty;
import com.yorku.users.Guest;
import com.yorku.users.Researcher;
import com.yorku.users.Student;
import com.yorku.users.User;
import com.yorku.users.UserFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserFactoryTest {

    @Test
    void testCreateStudent() {
        User user = UserFactory.createUser("student", "s@x.com", "p", "10");
        assertTrue(user instanceof Student);
    }

    @Test
    void testCreateFaculty() {
        User user = UserFactory.createUser("faculty", "f@x.com", "p", "11");
        assertTrue(user instanceof Faculty);
    }

    @Test
    void testCreateResearcher() {
        User user = UserFactory.createUser("researcher", "r@x.com", "p", "12");
        assertTrue(user instanceof Researcher);
    }

    @Test
    void testCreateGuest() {
        User user = UserFactory.createUser("guest", "g@x.com", "p", "13");
        assertTrue(user instanceof Guest);
    }
}
