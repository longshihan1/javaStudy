package Thread.ThreadDemo.bingxingtusuanfa.future;

/**
 * realdata的代理，获取realdata
 * Created by dell on 2017/2/27.
 */
public class FutureData implements Data {
    protected RealData realData=null;//Futuredata是realdata的包装
    protected boolean isReady=false;
    public synchronized void setRealData(RealData realData){
        if (isReady){
            return;
        }
        this.realData=realData;
        isReady=true;
        notifyAll();//realdata已经被注入，通知getResult()
    }
    @Override
    public synchronized String getResult() {//等待realdata构造完成
        while (!isReady){
            try {
                wait();//一直等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.result;
    }
}
