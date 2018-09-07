package Thread.ThreadDemo.bingxingtusuanfa.bussessproduct.suo;

/**
 * Created by dell on 2017/2/27.
 */
public class PCData {
    private final int intdata;

    public PCData(int intdata) {
        this.intdata = intdata;
    }

    public int getIntdata() {
        return intdata;
    }

    @Override
    public String toString() {
        return "data:"+intdata;
    }
}
