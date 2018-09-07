package Thread.ThreadDemo.xunhuan;

/**
 * Created by dell on 2017/2/20.
 */
public class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal "+orderNum;
    }
}
