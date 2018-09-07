package Thread.ThreadDemo.bingxingtusuanfa.danli;

/**
 * Created by dell on 2017/2/27.
 */
public class Singleton {
    private Singleton() {
        System.out.println("Singleton is create ");
    }

    /*private static Singleton instance = new Singleton();

    public static synchronized Singleton getInstance() {
        if (instance==null){//延时加载策略
            instance=new Singleton();
        }
        return instance;
    }*/
    private static class SingletonHolder{
        private static Singleton instance=new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }
}
