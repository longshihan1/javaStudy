package Thread.ThreadDemo.jdk.declarative;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/3/1.
 */
public class InstanceMethobRef {
    public static void main(String args[]) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
           // users.add(new User(i, "b" + Integer.toString(i)));
            users.add(uf.create(i, "b" + Integer.toString(i)));
        }


        //获取user的getname方法
        users.stream().map(User::getName).forEach(System.out::println);

    }

    static UserFactory<User> uf=User::new;

    @FunctionalInterface
    interface UserFactory<U extends User>{
        U create(int id, String name);

    }
}
