package ltttcode;

import java.util.Arrays;

/**
 *
 * 3-7,4-10,5-13
 *        0 1234 5678 9
 *
 * row=3: 0 4813 5792 6
 * row=4: 0 6157 2483 9
 * Created by dell on 2017/3/2.
 */
public class Zigzag_conversion {
    static String s="0123456789";
    static int nRows=3;
    public static void main(String args[]) {
        zigzag1();

    }

    public static String zigzag1(){
        int len = s.length();
        if (len == 0 || nRows < 2) return s;

        String ret = "";
        int lag = 2*nRows - 2; //循环周期
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < len; j += lag) {
                ret += s.charAt(j);

                //非首行和末行时还要加一个
                if (i > 0 && i < nRows-1) {
                    int t = j + lag - 2*i;
                    if (t < len) {
                        ret += s.charAt(t);
                    }
                }
            }
        }
        return ret;
    }
}
