package human_tests;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import com.yorku.App;
import com.yorku.coordinator.LabManager;

public class AppTest {

	// helper to mutate static field
	private void setLabManagerField(LabManager manager) throws Exception {
		Field field = App.class.getDeclaredField("labManager");
		field.setAccessible(true);
		field.set(null, manager);
	}

	// 1. Test initial state (before start() is called)
	@Test
	void testLabManagerInitiallyNull() throws Exception {
		setLabManagerField(null);
		assertNull(App.getLabManager());
	}

	@Test
	void testSetAndGetLabManager() throws Exception {
		LabManager dummyManager = new LabManager("test@yorku.ca");
		setLabManagerField(dummyManager);
		assertEquals(dummyManager, App.getLabManager());
	}


	@Test
	void testLabManagerNotNullAfterSet() throws Exception {
		LabManager dummyManager = new LabManager("test2@yorku.ca");
		setLabManagerField(dummyManager);
		assertNotNull(App.getLabManager());
	}

	// 4. Test multiple assignments
    @Test
	void testLabManagerOverwrite() throws Exception {
    	LabManager manager1 = new LabManager("A");
        LabManager manager2 = new LabManager("B");

        setLabManagerField(manager1);
        assertEquals(manager1, App.getLabManager());

        setLabManagerField(manager2);
        assertEquals(manager2, App.getLabManager());
    }

	// 5. Test null assignment
	@Test
	void testSetLabManagerToNull() throws Exception {
    	setLabManagerField(null);
    	assertNull(App.getLabManager());
	}

	// 6. Test class loading
	@Test
	void testAppClassLoads() {
		assertDoesNotThrow(() -> {
			Class.forName("com.yorku.App");
		});
	}

	// 7. Test main method does not crash (basic)
	@Test
	void testMainMethodExists() throws Exception {
		Method method = App.class.getMethod("main", String[].class);
		assertNotNull(method);
		assertTrue(Modifier.isStatic(method.getModifiers()));
	}

	// 8. Test getLabManager consistency
	@Test
	void testGetLabManagerConsistency() throws Exception {
		LabManager manager = new LabManager("c@yorku.ca");
		setLabManagerField(manager);
		assertSame(manager, App.getLabManager());
	}

	// 9. Test repeated calls
	@Test
	void testMultipleGetCalls() throws Exception {
		LabManager manager = new LabManager("d@yorku.ca");
		setLabManagerField(manager);
		assertEquals(manager, App.getLabManager());
		assertEquals(manager, App.getLabManager());
	}

	// 10. Edge case: reflection access
	@Test
	void testReflectionAccess() {
		assertDoesNotThrow(() -> {
			java.lang.reflect.Field field = App.class.getDeclaredField("labManager");
			field.setAccessible(true);
		});
	}
}
