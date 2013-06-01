package daoo.server.tasks;

import java.io.IOException;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Mingus
 * Date: 31/05/13
 * Time: 20:52
 * To change this template use File | Settings | File Templates.
 */
public class SleepyTask extends EchoTask
{
    private final long sleep;

    private SleepyTask(Socket socket, long sleep) {
        super(socket);
        this.sleep = sleep;
    }

    @Override public void task() throws IOException {
        super.task();
        print("sleeping...");
        sleep();
        print("waking up...");
    }

    private void sleep() {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException("Sleepy task interrupted!", e);
        }
    }
}
