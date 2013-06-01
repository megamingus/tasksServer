package daoo.server.server;

import com.sun.istack.internal.NotNull;
import daoo.server.TaskExecutor;
import daoo.server.TaskServer;
import daoo.server.tasks.EchoTask;
import daoo.server.tasks.EncodeTask;

import java.io.IOException;
import java.net.ServerSocket;

public class DaooTaskServer implements TaskServer {
    @Override public void start(@NotNull TaskExecutor executor, int port) {
        try {
            final ServerSocket serverSocket = new ServerSocket(port);
            while(true){
                executor.execute(new EncodeTask(serverSocket.accept()));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
