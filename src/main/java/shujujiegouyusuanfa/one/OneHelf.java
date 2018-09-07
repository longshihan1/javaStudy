package shujujiegouyusuanfa.one;

/**
 * Created by dell on 2017/3/22.
 */
public class OneHelf {
    public static void main(String args[]) {

    }

    public static int ones(int n){
        if (n<2){
            return n;
        }
        return n%2+ones(n/2);
    }
}
