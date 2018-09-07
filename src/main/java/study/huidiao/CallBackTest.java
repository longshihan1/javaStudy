package study.huidiao;

/**
 * Created by dell on 2017/4/27.
 * 回调模式-测试类
 */
public class CallBackTest {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);

        client.sendMsg("Server,Hello~");
    }
}
