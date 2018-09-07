import Handle.Message;

/**
 * Created by dell on 2017/1/9.
 */
public class TestAdd {
    public static void main(String args[]) {
        Message message=new Message();
        message.what=0;
        ChuliMsg(message);

        System.out.println(message.what);
    }

    private static void ChuliMsg(Message message) {
        message.what=1;
    }
}
