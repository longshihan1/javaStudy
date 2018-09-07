package Thread.ThreadDemo.bingxingtusuanfa.juzhen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by dell on 2017/2/28.
 */
public class MyRecursiveAction extends RecursiveAction {
    private long workLoad = 0;

    public MyRecursiveAction(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {

        if (workLoad > 16) {//16就是阈值
            System.out.println("Splitting workLoad : " + this.workLoad);

            List<MyRecursiveAction> subtasks = new ArrayList<>();
            subtasks.addAll(createSubtasks());
            for (RecursiveAction subrask : subtasks) {
                subrask.fork();
            }
        }else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
        }
    }

    private List<MyRecursiveAction> createSubtasks() {
        List<MyRecursiveAction> subtasks=new ArrayList<>();
        MyRecursiveAction myRecursiveAction1=new MyRecursiveAction(workLoad/2);
        MyRecursiveAction myRecursiveAction2=new MyRecursiveAction(workLoad/2);
        subtasks.add(myRecursiveAction1);
        subtasks.add(myRecursiveAction2);
        return subtasks;
    }
}
