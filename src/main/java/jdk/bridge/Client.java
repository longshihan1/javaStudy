package jdk.bridge;

/**
 * Created by dell on 2017/5/2.
 */
public class Client {
    public static void main(String args[]) {

        Car car=null;
        car=new SedanCar(new RainyTire());
        car.run();
        car=new SedanCar(new SandyTire());
        car.run();
        car=new RacingCar(new RainyTire());
        car.run();
        car=new RacingCar(new SandyTire());
        car.run();
    }
}
