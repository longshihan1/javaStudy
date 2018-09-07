package jdk.annina;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;

/**
 * Created by dell on 2017/5/4.
 */
public class Parent2<T> {
    private Class<T> entity;

    public Parent2() {
        init();
    }
    public void init() {
        entity = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        printAlias();
        doTest(entity);
    }

    /**
     * print alias during runtime
     */
    private  void printAlias() {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field :fields) {
            if (field.isAnnotationPresent(Alias.class)) {
                Alias alias = field.getAnnotation(Alias.class);
                System.out.println(alias.value());
            }
        }
    }

    /**
     * Test methods which are be annotated with @Test
     */
    private static void doTest(Object object) {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                try {
                    String methodName = test.value().length() == 0 ? method.getName() : test.value(); // if test.value() is empty, use `method.getName()`
                    System.out.printf("Testing. methodName: %s, id: %s\n", methodName, test.id());
                    if (Modifier.isStatic(method.getModifiers())) {
                        method.invoke(null); // static method
                    } else if (Modifier.isPrivate(method.getModifiers())) {
                        method.setAccessible(true);  // private method
                        method.invoke(object);
                    } else {
                        method.invoke(object);  // public method
                    }

                    System.out.printf("PASS: Method id: %s\n", test.id());
                } catch (Exception e) {
                    System.out.printf("FAIL: Method id: %s\n", test.id());
                    e.printStackTrace();
                }
            }
        }
    }
}
