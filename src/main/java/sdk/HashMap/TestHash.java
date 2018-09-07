package sdk.HashMap;

/**
 * Created by longshihan on 2017/4/1.
 * 测试hashmap
 */
public class TestHash {
    public static void main(String args[]) {

        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("a", 111);
        map.put("b", 222);
        map.put("c", 333);
        map.put("d", 444);
        map.put("e", 555);
        map.put(null, 123);
        System.out.println(map.toString());
        System.out.println("" + map.get(null));

        MyHashMap.MyIterator myIterator = map.myIterator();
        while (myIterator.hasNext()) {
            System.out.println("kkk:" + myIterator.next());
        }
    }
}
