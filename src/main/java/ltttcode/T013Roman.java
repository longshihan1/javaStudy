package ltttcode;

import java.util.HashMap;
import java.util.Map;

public class T013Roman {


    public static void main(String args[]) {

        System.out.println(""+romanToInt("IV"));
    }

    private static Map<Character, Integer> map = new HashMap() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };


    public static int romanToInt(String s) {
        int length = s.length();
        int result = 0;
        int preVal = 0;
        for (int i = length - 1; i >= 0; i--) {
            char key = s.charAt(i);
            int value = map.get(key);
            if (value >= preVal) {
                result += value;
            } else {
                result -= value;
            }

            preVal = value;
        }
        return result;
    }
}
