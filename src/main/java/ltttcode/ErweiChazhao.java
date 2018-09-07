package ltttcode;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 输入描述:
 * array： 待查找的二维数组
 * target：查找的数字
 * <p>
 * Created by dell on 2017/3/3.
 */
public class ErweiChazhao {
    public static void main(String args[]) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = i + j;
            }
        }
        int target = 9;
        boolean isexit = testArray1(arr, target);
    }

    /**
     * O(n*2)
     *
     * @param arr
     * @param target
     * @return
     */
    private static boolean testArray(int[][] arr, int target) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (target == arr[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * O(n)
     *
     * @param arr
     * @param target
     * @return
     */
    private static boolean testArray1(int[][] arr, int target) {
        int i = 0;
        int j = arr[i].length - 1;
        while (i <arr.length && j > 0) {
            if (arr[i][j] > target) {
                j--;
            } else if (arr[i][j] < target) {
                i++;
            } else if (arr[i][j] == target) {
                return true;
            }
        }
        return false;
    }

}
