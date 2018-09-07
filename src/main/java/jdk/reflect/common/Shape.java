package jdk.reflect.common;

/**
 * Created by dell on 2017/7/13.
 */
public abstract class Shape {
    void draw() {
        System.out.println(this + ".draw() ");
    }
    abstract public String toString();
}
