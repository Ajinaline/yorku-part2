package AI_assistant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.yorku.command.Command;

class CommandTest {

    @Test
    void executeInvokesImplementation() {
        RecordingCommand command = new RecordingCommand();

        assertFalse(command.isExecuted());
        command.execute();
        assertTrue(command.isExecuted());
    }

    @Test
    void lambdaCanImplementCommand() {
        boolean[] invoked = {false};
        Command command = () -> invoked[0] = true;

        command.execute();
        assertTrue(invoked[0]);
    }

    private static final class RecordingCommand implements Command {
        private boolean executed;

        @Override
        public void execute() {
            executed = true;
        }

        boolean isExecuted() {
            return executed;
        }
    }
}
