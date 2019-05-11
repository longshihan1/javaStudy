package ltttcode;

public class T009Palindrome {
    public static void main(String args[]){
        System.out.println(""+isPalindrome2(12334321));
    }

    public static boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }else if (x/10!=0) {
            String xx = String.valueOf(x);
            String[] ll=xx.split("");
            for (int i = 0; i <ll.length/2; i++) {
                if (!ll[i].equals(ll[ll.length-i-1])){
                    return false;
                }
            }
            return true;
        }else {
            return true;
        }
    }

    public static boolean isPalindrome2(int x) {
        //negative numbers are not palindrome
        if (x < 0)
            return false;

        // initialize how many zeros
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x != 0) {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;

            x = (x % div) / 10;
            div /= 100;
        }

        return true;
    }
}
