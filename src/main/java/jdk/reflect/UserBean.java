package jdk.reflect;


import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * Created by dell on 2017/4/27.
 */
public class UserBean {
    public String userName;

    private long userId;

    public UserBean(String userName, long userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public String getName() {
        return userName;
    }

    public long getId() {
        return userId;
    }

    @Ignore
    public static void staticMethod(String devName) {
        System.out.printf("Hi %s, I'm a static method", devName);
    }

    @Ignore
    public void publicMethod() {
        System.out.println("I'm a public method");
    }

    @Ignore
    private void privateMethod() {
        System.out.println("I'm a private method");
    }
}
