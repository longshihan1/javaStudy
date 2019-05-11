package ltttcode;

public class T007ReverseInt {


    public static void main(String args[]){
        System.out.println(""+ reverse(-1));
    }

    public static int reverse(int x) {
        if (x>Integer.MAX_VALUE||x<Integer.MIN_VALUE){
            return 0;
        }
        long res=0;
        int num=x;
        while (num!=0){
            int y=num%10;
            res=res*10+y;
            num=num/10;
        }
        if (res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
            return 0;
        }
        return (int)res;
    }
}
