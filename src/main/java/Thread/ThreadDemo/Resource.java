package Thread.ThreadDemo;

/**
 * Created by longshihan on 2016/12/14.
 */
public class Resource {
    private String name;
    private int id;
    private boolean hasGoods=false;

    public synchronized void set(String name){
        if (hasGoods){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name=name+"_"+id;
        id++;
        System.out.println("生产现场名称"+Thread.currentThread().getName()+"以生产商品为"+this.name);





    }

}
