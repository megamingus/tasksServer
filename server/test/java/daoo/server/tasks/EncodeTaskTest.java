package daoo.server.tasks;

import com.sun.xml.internal.bind.AnyTypeAdapter;
import daoo.ioc.MessageEncoderProvider;
import daoo.server.Task;
import org.junit.Test;

import java.io.BufferedReader;
import java.net.Socket;

import static org.mockito.Mockito.*;


/**
 * Created with IntelliJ IDEA.
 * User: Mingus
 * Date: 14/06/13
 * Time: 05:39
 * To change this template use File | Settings | File Templates.
 */


public class EncodeTaskTest {

    final Socket mockitoSocket;
    final Task task;


    public EncodeTaskTest(){
        mockitoSocket=mock(Socket.class);
        task=new EncodeTask(mockitoSocket);
    }

    @Test
    public void testTask() throws Exception {
        MessageEncoderProvider mockmep=mock(MessageEncoderProvider.class);
        when(MessageEncoderProvider.getFirstEncoder().encode("hola")).thenReturn("okey".getBytes());
        when(MessageEncoderProvider.getFirstEncoder().decode("okey".getBytes())).thenReturn("hola");
        new Thread(task).start();



    }
}
