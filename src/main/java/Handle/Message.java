package Handle;

/**
 * Created by longshihan on 2016/12/11.
 */
public class Message {
    Handler target;//持有当前的信息
    public int what;
    public Object obj;

    @Override
    public String toString() {
        return obj.toString();
    }
}
