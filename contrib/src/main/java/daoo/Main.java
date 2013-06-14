package daoo;

import daoo.server.TaskExecutorProvider;
import daoo.server.TaskServer;
import daoo.server.server.DaooTaskServer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final TaskServer server = new DaooTaskServer();
        server.start(TaskExecutorProvider.getExecutor(), 8080);
        //server.start(new QueuedTaskExecutor(), 8080);
    }
}
