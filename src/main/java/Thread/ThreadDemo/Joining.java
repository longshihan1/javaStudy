package Thread.ThreadDemo;

/**
 * Created by dell on 2017/2/17.
 */
public class Joining {
    public static void main(String args[]) {
        Sleeper
                sleeper = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);
        Joiner
                dopey = new Joiner("Dopey", sleeper),
                doc = new Joiner("DOC", grumpy);
        grumpy.interrupt();
    }
}
