package daoo.server.tasks;

import daoo.ioc.MessageEncoderProvider;
import daoo.server.Task;

import java.io.*;
import java.net.Socket;
import java.net.URI;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Mingus
 * Date: 31/05/13
 * Time: 20:25
 * To change this template use File | Settings | File Templates.
 */


public class EncodeTask extends Task{

    public EncodeTask(@NotNull Socket socket) {
        super(socket);
    }

    @Override
    protected void task() throws IOException {
        doStuff();
    }

    private void doStuff() throws IOException {

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
        final String action=path.split("/")[1];
        try{
            final String message=path.substring(action.length() + 2);
            if(action.toLowerCase().equals("encode")){
                out.write(new String(MessageEncoderProvider.getFirstEncoder().encode(message)));
            }
            if(action.toLowerCase().equals("decode")){
                out.write(MessageEncoderProvider.getFirstEncoder().decode(message.getBytes()));
            }
        }catch (Exception e){
           out.write(action +" is not recognized, please use /encode/ or /decode/ ");
        }
        out.write("\r\n");

        out.close();
        in.close();
    }
}
