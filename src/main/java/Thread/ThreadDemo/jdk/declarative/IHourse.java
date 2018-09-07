package Thread.ThreadDemo.jdk.declarative;

/**
 * 函数式接口
 * Created by dell on 2017/3/1.
 */
public interface IHourse {
    void eat();
    default void run(){
        System.out.println("hourse run");
    }
}
