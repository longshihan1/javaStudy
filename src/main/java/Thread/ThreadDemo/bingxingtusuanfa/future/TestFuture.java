package Thread.ThreadDemo.bingxingtusuanfa.future;

import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2017/2/27.
 */
public class TestFuture {
    public static void main(String args[]) {
        Client client = new Client();
        //这里会立即返回。因为得到futuredata而不是realdata
        Data data = client.request("name");
        System.out.println("请求完毕");
        try {
            //其他业务逻辑处理
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据+" + data.getResult());
    }
}
