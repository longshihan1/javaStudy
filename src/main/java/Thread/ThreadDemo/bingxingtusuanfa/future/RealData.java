package Thread.ThreadDemo.bingxingtusuanfa.future;

import java.util.concurrent.TimeUnit;

/**
 * 真实数据的处理
 * Created by dell on 2017/2/27.
 */
public class RealData implements Data {
    protected final String result;

    public RealData(String result) {
        //构造的比较慢
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(result);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        this.result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
