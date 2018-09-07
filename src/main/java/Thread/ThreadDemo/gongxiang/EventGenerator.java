package Thread.ThreadDemo.gongxiang;

/**
 * Created by dell on 2017/2/17.
 */
public class EventGenerator extends IntGenerator {
   private int currentEventValue=0;
    @Override
    public int next() {
        ++currentEventValue;
        ++currentEventValue;
        return currentEventValue;
    }

    public static void main(String args[]) {
    EvebChecker.test(new EventGenerator());
    }
}
