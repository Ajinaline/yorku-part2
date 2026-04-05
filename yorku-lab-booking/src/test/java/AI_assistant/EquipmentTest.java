package AI_assistant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import org.junit.jupiter.api.Test;

import com.yorku.equipment.Equipment;

public class EquipmentTest {

    @Test
    void testSetDescriptionCorrectness() {
        Equipment eq = new Equipment("E1", "Drill", "Room A");

        eq.setDescription("Hammer");
        assertEquals("Hammer", eq.getDescription());
    }

    @Test
    void testCloneNotSameObject() {
        Equipment eq1 = new Equipment("E1", "Drill", "Room A");
        Equipment eq2 = eq1.clone();

        assertNotNull(eq2);
        assertNotSame(eq1, eq2);
    }

    @Test
    void testClonePreservesData() {
        Equipment eq1 = new Equipment("E1", "Drill", "Room A");
        Equipment eq2 = eq1.clone();

        assertEquals("E1", eq2.getId());
        assertEquals("Drill", eq2.getDescription());
        assertEquals("Room A", eq2.getLocation());
    }

    @Test
    void testSetAvailable() {
        Equipment eq = new Equipment("E1", "Drill", "Room A");

        eq.setAvailable(false);
        assertFalse(eq.isAvailable());
    }
}