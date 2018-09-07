package Thread.ThreadDemo.bingxingtusuanfa.paixu;

/**
 * Created by dell on 2017/2/28.
 */
public class Paixu {
    public static void main(String args[]) {

    }

    public static void shellSort(int[] arr){
        //计算最大的h值
        int h=1;
        while (h<=arr.length/3){
            h=h*3+1;
        }
        while (h>0){
            for (int i = h; i <arr.length; i++) {
                if (arr[i] < arr[i-h]) {
                    int temp=arr[i];
                    int j=i-h;
                    while (j>=0&&arr[j]>temp){
                        arr[j+h]=arr[j];
                        j-=h;
                    }
                    arr[j+h]=temp;
                }
            }
            h=(h-1)/3;
        }
    }
}
