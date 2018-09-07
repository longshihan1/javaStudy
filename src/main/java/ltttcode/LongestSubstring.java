package ltttcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找字符中的最大非重复子串(不要求连续)
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for “abcabcbb” is “abc”,
 * which the length is 3. For “bbbbb” the longest substring is “b”, with the length of 1.
 * Created by dell on 2017/3/2.
 */
public class LongestSubstring {
    static String currentStr = "abcabcbbd";

    public static void main(String args[]) {

        lengthOfLongestSubstring(currentStr);
    }

    private static void lengthOfLongestSubstring(String s) {
        String[] str = s.split("");
        // 当前处理的开始位置
        int start = 0;
        // 记录到的最大非重复子串长度
        int result = 0;
        // 访问标记，记录最新一次访问的字符和位置
        Map<Character, Integer> map = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果字符已经出现过(在标记开位置算起)，就重新标记start
            if (map.containsKey(ch) && map.get(ch) >= start) {
                start = map.get(ch) + 1;
            }
            // 如果没有出现过就求最大的非重复子串的长度
            else {
                result = Math.max(result, i - start + 1);
            }

            // 更新访问记录
            map.put(ch, i);
        }
    }
}
