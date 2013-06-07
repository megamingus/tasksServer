package daoo.server.tasks;

import daoo.server.Task;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Mingus
 * Date: 31/05/13
 * Time: 20:50
 * To change this template use File | Settings | File Templates.
 */
public class EchoTask extends Task
{
    public EchoTask(@NotNull Socket socket) { super(socket); }

    @Override protected void task() throws IOException {
        print("echoing...");
        echo();
    }

    private void echo() throws IOException {

        final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        final StringBuilder header = new StringBuilder();

        while (true) {
            final String s = in.readLine();
            if(s == null || s.isEmpty()) break;
            header.append(s);
        }

        out.write("HTTP/1.1 200 OK\r\n");
        out.write("Content-Type: text/plain\r\n");

        // Echo path
        out.write("\r\n");
        final String path = getHeaderPath(header.toString());
        out.write(path+"\r\n");

        out.close();
        in.close();
    }
}