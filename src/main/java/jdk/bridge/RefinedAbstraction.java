package jdk.bridge;

/**
 * Created by dell on 2017/5/2.
 */
public class RefinedAbstraction extends Abstraction {
    protected RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    public void refinedOperation() {
        //对Abstraction中的方法进行扩展
        System.out.println(" 扩展之后的方法");
    }
}
