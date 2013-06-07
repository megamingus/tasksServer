package daoo.server.tasks;

/**
 * Created with IntelliJ IDEA.
 * User: Mingus
 * Date: 31/05/13
 * Time: 20:51
 * To change this template use File | Settings | File Templates.
 */

import java.io.IOException;
import java.net.Socket;
import org.jetbrains.annotations.NotNull;

public class InfiniteTask extends EchoTask
{
    private InfiniteTask(@NotNull Socket socket) { super(socket); }

    @Override public void task() throws IOException {
        super.task();
        print("endless...");
        endless();
    }

    private void endless() {
        //noinspection InfiniteLoopStatement,StatementWithEmptyBody
        for (;;) {}
    }
}
