package ltttcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，找到2个数字，这样他们就可以添加到一个特定的目标号。功能twosum应该返回两个数字，他们总计达目标数，其中index1必须小于index2。
 * 请注意，你的答案返回（包括指数和指数）不为零的基础。你可以假设每个输入都有一个解决方案。
 * 输入数字numbers= { 2，7，11，15 }，目标= 9输出：index1 = 1，index2= 2
 * Created by dell on 2017/3/1.
 * <p>
 * 1,首先同样分配一个数组空间，将数据拷贝
 * <p>
 * 2，将拷贝的数组排序
 * <p>
 * 3，对排序数组，建立两个查找“指针”，一个在数组头，一个在数组尾部，依次相加比较，如果大了，尾部向前进一位，如果小了，头部向后进一位，不断的递归
 * 直至有相等的情况或者头部与尾部交叉的情况发生，返回结果。O(logn)
 *
 * 上面的方法并不好，因为无序，求的是无序的位置，应该是下面的方法。
 * 递归，将数据依次相减，去map中查找数据。时间复杂度：O(n/2),空间复杂度：O(1),
 * <p>
 * 如果只找数据是哪个符合的话，第一种方法。
 */
public class TwoSum {
    static int[] arrr = {11, 7, 11, 8, 2, 16, 15};
    static int tager = 19;

    public static void main(String args[]) {
        int[] arr=Arrays.stream(arrr).sorted().toArray();
        Arrays.stream(twoSum3(arr, tager, 0, arrr.length-1)).forEach(System.out::println);
        //Arrays.stream(twoSum2(arrr, tager)).forEach(System.out::println);
        // Arrays.stream(twoSum(arrr, tager)).forEach(System.out::println);
    }

    /**
     * 递归，将数据依次相减，去map中查找数据。时间复杂度：O(n/2),空间复杂度：O(1),
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] result = {map.get(numbers[i]) + 1, i + 1};
                return result;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        int[] result = {};
        return result;
    }

    /**
     * 实现和上面一样
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i]))
                map.put(target - numbers[i], i + 1);
            else {
                res[0] = map.get(numbers[i]);
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }


    /**
     * 排序两头并进法，最后还得查找数字所在的位置
     * @param numbers
     * @param target
     * @param start
     * @param end
     * @return
     */
    public static int[] twoSum3(int[] numbers, int target, int start, int end) {
        int[] current=numbers;
        if (numbers[start] + numbers[end] > target) {
            end--;
            if (end <= start) {
                return new int[2];
            }
            current=twoSum3(numbers, target, start, end);
        } else if (numbers[start] + numbers[end] < target) {
            start++;
            if (start >= end) {
                return new int[2];
            }
           current= twoSum3(numbers, target, start, end);

        } else {
            current=new int[]{numbers[start], numbers[end]};
        }
        return current;
    }
}
