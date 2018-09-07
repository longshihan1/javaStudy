package jdk.bridge;

/**
 * Created by dell on 2017/5/2.
 */
public class RacingCar extends Car {
    public RacingCar(ITire tire) {
        super(tire);
    }

    @Override
    public void run() {
        System.out.println("racing "+getTire().run());
    }
}
