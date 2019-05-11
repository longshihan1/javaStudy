package ltttcode;

public class T005LongestPalin {


    public static void main(String[] args) {

        T005LongestPalin t005LongestPalin=new T005LongestPalin();
        System.out.println(""+t005LongestPalin.longestPalindrome("babad"));
    }

    int st, end;

    public  String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            helper(chars, i, i);
            helper(chars, i, i + 1);
        }
        return s.substring(st, end + 1);
    }

    private  void helper(char[] chars, int l, int r) {
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            --l;
            ++r;
        }
        if (end - st < r - l - 2) {
            st = l + 1;
            end = r - 1;
        }
    }
}
