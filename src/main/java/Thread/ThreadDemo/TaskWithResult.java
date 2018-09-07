package Thread.ThreadDemo;


import java.util.concurrent.Callable;

/**
 * Created by dell on 2017/2/15.
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }


    @Override
    public String call() throws Exception {
        return "result of TaskWithResut" + id;
    }
}



