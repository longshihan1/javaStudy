package jdk.reflect;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.lang.reflect.*;

/**
 * Created by dell on 2017/4/27.
 */
public class TestReflect {
    public static void main(String args[]) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {

        Class userBeanClass = UserBean.class;
        Field[] fields = userBeanClass.getDeclaredFields();

        for (Field field : fields) {
            String fieldString = "";
            fieldString += Modifier.toString(field.getModifiers()) + " "; // `private`
            fieldString += field.getType().getSimpleName() + " "; // `String`
            fieldString += field.getName(); // userName`
            fieldString += ";";
            System.out.println(fieldString);
        }
        System.out.println(" ");
        Method[] methods = userBeanClass.getDeclaredMethods();
        for (Method method : methods) {
            String methodString = Modifier.toString(method.getModifiers()) + " " ; // private static
            methodString += method.getReturnType().getSimpleName() + " "; // void
            methodString += method.getName() + "("; // staticMethod
            Class[] parameters = method.getParameterTypes();
            for (Class parameter : parameters) {
                methodString += parameter.getSimpleName() + " "; // String
            }
            methodString += ")";
            System.out.println(methodString);
        }
        System.out.println(" ");

        Constructor[] constructors = userBeanClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String s = Modifier.toString(constructor.getModifiers()) + " ";
            s += constructor.getName() + "(";
            Class[] parameters = constructor.getParameterTypes();
            for (Class parameter : parameters) {
                s += parameter.getSimpleName() + ", ";
            }
            s += ")";
            System.out.println(s);
        }
        System.out.println(" ");

        for (Method method : methods) {
            if (method.isAnnotationPresent(Ignore.class)) { // 判断是否被 @Invoke 修饰
                if (Modifier.isStatic(method.getModifiers())) { // 如果是 static 方法
                    method.invoke(null, "wingjay"); // 直接调用，并传入需要的参数 devName
                } else {
                    Class[] params = {String.class, long.class};
                    Constructor constructor = userBeanClass.getDeclaredConstructor(params); // 获取参数格式为 String,long 的构造函数
                    Object userBean = constructor.newInstance("wingjay", 11); // 利用构造函数进行实例化，得到 Object
                    if (Modifier.isPrivate(method.getModifiers())) {
                        method.setAccessible(true); // 如果是 private 的方法，需要获取其调用权限
                    }
                    method.invoke(userBean); // 调用 method，无须参数
                }
            }
        }







    }


}
