package jdk.bridge;

/**
 * Created by dell on 2017/5/2.
 */
public abstract class Abstraction {
    private Implementor implementor;

    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }
    public void operation(){
        implementor.operationImpl();
    }
}
