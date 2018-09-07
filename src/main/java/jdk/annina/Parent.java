package jdk.annina;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dell on 2017/5/4.
 * 运行时获取注解，首先创建一个基类：
 */
public class Parent<T> {
    private Class<T> entity;

    public Parent() {
        init();
    }

    @SuppressWarnings("unchecked")
    public List<SortableField> init() {

        List<SortableField> list = new ArrayList<>();
        /**getClass().getGenericSuperclass()返回表示此 Class 所表示的实体（类、接口、基本类型或 void）
         * 的直接超类的 Type(Class<T>泛型中的类型)，然后将其转换ParameterizedType。。
         *  getActualTypeArguments()返回表示此类型实际类型参数的 Type 对象的数组。
         *  [0]就是这个数组中第一个了。。
         *  简而言之就是获得超类的泛型参数的实际类型。。
         *  */
        entity = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        //      FieldMeta filed = entity.getAnnotation(FieldMeta.class);
        if (this.entity != null) {

            /**返回类中所有字段，包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段
             * entity.getFields();只返回对象所表示的类或接口的所有可访问公共字段
             * 在class中getDeclared**()方法返回的都是所有访问权限的字段、方法等；
             * 可看API
             * */
            Field[] fields = entity.getDeclaredFields();
            for (Field f : fields) {
                //获取字段中filedmeta的注解
                FieldMeta meta = f.getAnnotation(FieldMeta.class);
                if (meta != null) {
                    SortableField sf = new SortableField(meta, f);
                    list.add(sf);
                }
            }
            //返回对象所表示的类和接口的所有可访问的公共方法
            Method[] methods = entity.getMethods();
            for (Method m : methods) {
                FieldMeta meta = m.getAnnotation(FieldMeta.class);
                if (meta != null) {
                    SortableField sf = new SortableField(meta, m.getName(), m.getReturnType());
                    list.add(sf);
                }
            }
            //这种方法是新建FieldSortCom类实现Comparator接口，来重写compare方法实现排序
//          Collections.sort(list, new FieldSortCom());
            Collections.sort(list, new Comparator<SortableField>() {
                @Override
                public int compare(SortableField o1, SortableField o2) {
                    return o1.getMeta().order() - o2.getMeta().order();
                }
            });
        }
        return list;
    }
}
