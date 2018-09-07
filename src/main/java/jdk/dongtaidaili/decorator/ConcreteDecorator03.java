package jdk.dongtaidaili.decorator;

/**
 * Created by dell on 2017/5/2.
 *  具体装饰类02
 */
public class ConcreteDecorator03 extends Decorator {

    public ConcreteDecorator03(AbstractSubject subject) {
        super(subject); //调用父类装饰类的构造器
    }

    /**
     * 覆盖继承树上的接口中的request()方法，用于装饰原对象
     */
    public void request() {
        super.subject.request();
        System.out.println("第三层装饰 ... 装饰在原主题之后");
    }
}
