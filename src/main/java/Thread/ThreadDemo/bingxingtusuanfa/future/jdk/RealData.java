package Thread.ThreadDemo.bingxingtusuanfa.future.jdk;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/28.
 */
public class RealData implements Callable<String> {
    private String para;

    public RealData(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            TimeUnit.MILLISECONDS.sleep(100);
        }
        return sb.toString();
    }
}
