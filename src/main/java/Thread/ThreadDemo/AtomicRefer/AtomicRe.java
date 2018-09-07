package Thread.ThreadDemo.AtomicRefer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by dell on 2017/2/27.
 */
public class AtomicRe {
    static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19, 0);

    public static void main(String args[]) {

        for (int i = 0; i < 3; i++) {
            final int timestap = money.getStamp();
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.getReference();
                            if (m < 20) {
                                if (money.compareAndSet(m, m + 20, timestap, timestap + 1)) {
                                    System.out.println("余额小于20，充值：" + money.getReference());
                                    break;
                                }
                            } else {
                                // System.out.println("钱不够");
                                break;
                            }
                        }
                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true) {
                        int timestap1 = money.getStamp();
                        Integer m = money.getReference();
                        if (m > 10) {
                            System.out.println("大于10元");
                            if (money.compareAndSet(m, m - 10, timestap1, timestap1 + 1)) {
                                System.out.println("成功消费10元，余额：" + money.getReference());
                                break;
                            }
                        } else {
                            System.out.println("没有足够的余额");
                        }
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
