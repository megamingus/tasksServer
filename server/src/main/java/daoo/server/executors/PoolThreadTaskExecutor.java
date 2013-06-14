package daoo.server.executors;

import com.sun.istack.internal.NotNull;
import daoo.server.Task;
import daoo.server.TaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolThreadTaskExecutor implements TaskExecutor {

    private final ExecutorService pool;

    public PoolThreadTaskExecutor() {
        pool = Executors.newFixedThreadPool(10);     //http://stackoverflow.com/questions/7274371/java-executor-service-thread-pool
    }

    @Override public void execute(@NotNull Task task) {
        pool.execute(task);
    }


}
