package daoo.server.task_executors;

import com.sun.istack.internal.NotNull;
import daoo.server.Task;
import daoo.server.TaskExecutor;

public class QueuedTaskExecutor implements TaskExecutor {
    @Override public void execute(@NotNull Task task) {
        throw new RuntimeException("To be implemented!");
    }
}
