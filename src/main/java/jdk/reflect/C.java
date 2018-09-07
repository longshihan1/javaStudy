package jdk.reflect;

/**
 * Created by longshihan on 2017/4/30.
 */
public class C implements A {
    @Override
    public void f() { System.out.println("public C.f()"); }
    public void g() { System.out.println("public C.g()"); }
    protected void v () { System.out.println("protected C.v()"); }
    void u() { System.out.println("package C.u()"); }
    private void w() { System.out.println("private C.w()"); }
}
