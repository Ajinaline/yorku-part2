package AI_assistant;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import com.yorku.App;
import com.yorku.coordinator.LabManager;

class AppTest {

    @Test
    void labManagerIsNullByDefault() throws Exception {
        setLabManager(null);
        assertNull(App.getLabManager());
    }

    @Test
    void getterReturnsInjectedLabManager() throws Exception {
        LabManager manager = new LabManager("assistant@yorku.ca");
        try {
            setLabManager(manager);
            assertSame(manager, App.getLabManager());
        } finally {
            setLabManager(null);
        }
    }

    private static void setLabManager(LabManager manager) throws Exception {
        Field field = App.class.getDeclaredField("labManager");
        field.setAccessible(true);
        field.set(null, manager);
    }
}
