package jdk.bridge;

/**
 * Created by dell on 2017/5/2.
 */
public class SedanCar extends Car {
    public SedanCar(ITire tire) {
        super(tire);
    }

    @Override
    public void run() {
        System.out.println("Sedan "+getTire().run());
    }
}
