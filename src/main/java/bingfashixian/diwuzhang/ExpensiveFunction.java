package bingfashixian.diwuzhang;

import java.math.BigInteger;

/**
 * Created by dell on 2017/3/6.
 */
public class ExpensiveFunction implements Computable<String,BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }
}
