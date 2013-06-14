package daoo.server.executors;

import com.sun.istack.internal.NotNull;
import daoo.server.Task;
import daoo.server.TaskExecutor;

import java.util.ArrayList;
import java.util.List;

public class QueuedTaskExecutor extends Thread implements TaskExecutor {

    private List<Task> queue;
    private Thread thread;

    @Override public void execute(@NotNull Task task) {
        queue.add(task);
    }

    public QueuedTaskExecutor(){
        queue=new ArrayList<Task>();
        thread=new Thread();
        start();
    }

    public void run (){
        while(true){
            if(!thread.isAlive() && !queue.isEmpty()){
                thread=new Thread(queue.remove(0));
                thread.start();
            }
        }
    }
}
