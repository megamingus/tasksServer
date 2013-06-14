package daoo.server;

import java.util.ServiceLoader;

/**
 * Created with IntelliJ IDEA.
 * User: Mingus
 * Date: 07/06/13
 * Time: 13:15
 * To change this template use File | Settings | File Templates.
 */
public class TaskExecutorProvider {

    public static TaskExecutor getExecutor(){
        final ServiceLoader<TaskExecutor> loader = ServiceLoader.load(TaskExecutor.class);
        for (TaskExecutor taskExecutor : loader) {
            return taskExecutor;
        }
        throw new Error("No TaskExecutor found");
    }
}
