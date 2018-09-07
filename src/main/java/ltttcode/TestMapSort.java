package ltttcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dell on 2017/3/14.
 */
public class TestMapSort {
    public static void main(String args[]) {
        Map<String, Integer> us = new HashMap<String, Integer>();
        // Map<String, Integer> us = new TreeMap<String, Integer>();
        us.put("f1", 12);
        us.put("f2", 13);
        us.put("f5", 22);
        us.put("f4", 42);
        us.put("f3", 15);
        us.put("f8", 21);
        us.put("f6", 123);
        us.put("f7", 1);
        us.put("f9", 19);
        System.out.println(us.toString());
        System.out.println(new TreeMap<String, Integer>(us));
    }
}
