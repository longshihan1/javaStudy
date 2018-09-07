package jdk.annina;

import java.util.List;

/**
 * Created by dell on 2017/5/4.
 */
public class TestUserBean {
    public static void main(String args[]) {
        Parent2 c = new ChildAnno();
        c.init();//获取泛型中类里面的注解
    }
}
