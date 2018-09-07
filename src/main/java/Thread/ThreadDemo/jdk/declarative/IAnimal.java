package Thread.ThreadDemo.jdk.declarative;

/**
 * Created by dell on 2017/3/1.
 */
public interface IAnimal {
    default void breath(){
        System.out.println("breath");
    }
}
