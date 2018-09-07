package jdk.dongtaidaili.commonproxy;

/**
 * Created by dell on 2017/4/24.
 */
public class DogProxy implements IDog{
    private BlackDog mBlackDog;

    public DogProxy(BlackDog blackDog){
        this.mBlackDog = blackDog;
    }

    @Override
    public void eat() {
        System.out.println("代理狗"+"----  在吃之前先撒个欢  -----");
        mBlackDog.eat();
    }

    @Override
    public void drink() {
        mBlackDog.drink();
        System.out.println("代理狗"+"----  在喝之后撒个欢  -----");
    }
}
