package ltttcode;

/**
 * Created by dell on 2017/3/2.
 */
public class Quickpai {

    public static void main(String args[]) {
        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        //quick_sort(arr, 0, arr.length-1);
       int s= maxProfit(arr);
        System.out.println(" "+s);

    }

    //快速排序
    static void quick_sort(int s[], int l, int r) {
        if (l < r) {
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int maxProfit = 0;
        int curMin = prices[0];

        for (int i = 1; i < prices.length; i++) {
            curMin = Math.min(curMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - curMin);
        }

        return maxProfit;
    }

}
