package Thread.ThreadDemo.jdk.declarative;

import java.util.Comparator;

/**
 * Created by dell on 2017/3/1.
 */
public class Mule implements IAnimal, IHourse,IDonkey,Comparator{

    public static void main(String args[]) {
        Mule mule = new Mule();
        mule.run();
        mule.breath();

        Comparator<String> cmp=Comparator.comparingInt(String::length)
                .thenComparing(String.CASE_INSENSITIVE_ORDER);
        int compare = cmp.compare("ccc", "aawwww");
        System.out.println(" "+compare);
    }


    @Override
    public void eat() {
        System.out.println("Mule eat");
    }

    @Override
    public void run() {
        IHourse.super.run();
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
