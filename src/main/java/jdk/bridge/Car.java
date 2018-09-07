package jdk.bridge;

/**
 * Created by dell on 2017/5/2.
 */
public abstract class Car {
    private ITire tire;

    public Car(ITire tire) {
        this.tire = tire;

    }

    public ITire getTire() {
        return tire;
    }

    public abstract void run();
}
