package jdk.dongtaidaili.commonproxy;

/**
 * Created by dell on 2017/4/24.
 */
public class BlackDog implements IDog{
    @Override
    public void eat() {
        System.out.println("BlackDog"+"----  eat  -----");
    }

    @Override
    public void drink() {
        System.out.println("BlackDog"+"----  drink  -----");
    }
}
