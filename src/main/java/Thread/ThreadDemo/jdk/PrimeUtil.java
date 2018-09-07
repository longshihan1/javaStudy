package Thread.ThreadDemo.jdk;

/**
 * 并行流
 * Created by dell on 2017/3/1.
 */
public class PrimeUtil {
    public static boolean isPrime(int num) {
        int tmp = num;
        if (tmp < 2) {
            return false;
        }
        for (int i = 0; Math.sqrt(tmp) >= i; i++) {
            if (tmp % i == 0) {
                return false;
            }
        }
        return true;
    }
}
