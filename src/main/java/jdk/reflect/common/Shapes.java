package jdk.reflect.common;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2017/7/13.
 */
public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle()
        );
        for (Shape shape : shapeList) {
            shape.draw();
        }
    }
}
