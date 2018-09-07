package ltttcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2017/3/9.
 */
public class TestHelper {
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();

        //"c"在Arraylist不连续存储

         list.add("c");
         list.add("a");
         list.add("c");
         list.add("b");
         list.add("c");
         list.add("d");
         list.add("c");
        removeListElement2(list);
        System.out.println(" "+list.toString());

    }

    public static void removeListElement2(List<String> list) {
        for(int i=0;i<list.size();i++) {
            if("c".equals(list.get(i))) {
                list.remove(i);
                --i;//删除了元素，迭代的下标也跟着改变
            }
        }
    }
}
