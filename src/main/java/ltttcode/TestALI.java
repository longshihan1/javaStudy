package ltttcode;

import ltttcode.addtwonumber.ListNode;
import ltttcode.zhan.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 标号1-n的n个人首尾相接，1到3报数，报到3的退出，求最后一个人的标号
 * 给定一个字符串，求第一个不重复的字符    abbcad -> c
 * 字符串中出现最多的字符
 * Created by dell on 2017/3/9.
 */
public class TestALI {
    public static void main(String args[]) {

        int result = NumberOne();
        System.out.println(" " + result);

        String result_str = NumberTwo();
        System.out.println(" " + result_str);
        String result_s = NumberThree();

    }

    /**
     * 字符串中出现最多的字符
     *
     * @return
     */
    private static String NumberThree() {
        String tets = "wencwecbnbcoajdbca";
        String[] test_str = tets.split("");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < test_str.length; i++) {
            if (!map.containsKey(test_str[i])) {
                map.put(test_str[i], 1);
            } else {
                map.put(test_str[i], map.get(test_str[i]) + 1);
            }
        }
        int maxCount=0;
        String max=null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                max = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return max;
    }

    /**
     * 给定一个字符串，求第一个不重复的字符    abbcad -> c
     *
     * @return
     */
    private static String NumberTwo() {
        String test = "abbcadxc";
        String[] test_str = test.split("");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < test_str.length; i++) {
            if (!map.containsKey(test_str[i])) {
                map.put(test_str[i], 1);
            } else {
                map.put(test_str[i], map.get(test_str[i]) + 1);
            }
        }
        for (Map.Entry<String, Integer> enty : map.entrySet()) {
            if (enty.getValue() == 1) {
                return enty.getKey();
            }

        }
        return "";
    }

    /**
     * 标号1-n的n个人首尾相接，1到3报数，报到3的退出，求最后一个人的标号
     *
     * @return
     */
    private static int NumberOne() {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        ListNode temp = new ListNode(arr[0]);
        ListNode first = temp;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        temp.next = first;
        int count = 1;
        while (first != null && first.val != first.next.val) {
            if (count % 3 == 2) {
                first.next = first.next.next;
                first = first.next;
                count = 1;
                continue;
            }
            first = first.next;
            count++;
        }
        return first.val;
    }


}
