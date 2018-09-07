package ltttcode;

/**
 * Created by dell on 2017/3/14.
 */
public class TestCa {
    public static void main(String args[]) {
        int x = 0x203;
        int y = -0x203;
        int i = x & y;
        System.out.println(" "+i);
        System.out.println(" "+0x00000111);
    }
}
