package Thread.ThreadDemo.bingxingtusuanfa.future;

/**
 * Created by dell on 2017/2/27.
 */
public class Client {
    public Data request(final String queryStr){
        final FutureData futureData=new FutureData();
        new Thread(){
            @Override
            public void run() {
                //构造慢。线程中
                RealData realData=new RealData(queryStr);
                futureData.setRealData(realData);
            }
        }.start();
        return futureData;//futuredata马上返回
    }
}
