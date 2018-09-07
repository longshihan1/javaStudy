package Thread.ThreadDemo.jdk.declarative;

/**
 * Created by dell on 2017/3/1.
 */
public interface IDonkey {
    void eat();
    default void run(){
        System.out.println("Donkey run");
    }
}
