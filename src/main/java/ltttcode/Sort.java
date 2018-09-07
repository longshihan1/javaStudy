package ltttcode;

import java.util.Arrays;
import java.util.Random;

/**
 * 手写排序算法集合
 * Created by dell on 2017/3/3.
 */
public class Sort {
    public static void main(String args[]) {
        int[] currents = new int[10];
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            currents[i] = random.nextInt(100);
        }
        Arrays.stream(currents).forEach((i) -> System.out.print(i + ","));
        System.out.println(" ");
        //Arrays.stream(maopao(currents)).forEach((i)->System.out.print(i+","));
        //Arrays.stream(xuznze(currents)).forEach((i) -> System.out.print(i + ","));
//        Arrays.stream(charu(currents)).forEach((i) -> System.out.print(i + ","));
        Arrays.stream(quicksort(currents,0,currents.length-1)).forEach((i) -> System.out.print(i + ","));
    }

    /**
     * 插入排序
     *
     * @param currents
     * @return
     */
    private static int[] charu(int[] currents) {
        for (int i = 1; i < currents.length; i++) {
            if (currents[i - 1] > currents[i]) {
                int temp = currents[i];
                int j = i;
                while (j > 0 && currents[j - 1] > temp) {
                    currents[j] = currents[j - 1];
                    j--;
                }
                currents[j] = temp;
            }
        }
        return currents;
    }

    /**
     * 选择排序
     *
     * @param currents
     * @return
     */
    private static int[] xuznze(int[] currents) {
        for (int i = 0; i < currents.length; i++) {
            int min = i; /* 将当前下标定义为最小值下标 */
            for (int j = i + 1; j < currents.length; j++) {
                if (currents[min] > currents[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swpa(currents, min, i);
            }
        }
        return currents;
    }

    /**
     * 冒泡排序
     *
     * @param currents
     * @return
     */
    private static int[] maopao(int[] currents) {
        int temp = 0;
        for (int i = 0; i < currents.length; i++) {
            for (int j = i + 1; j < currents.length; j++) {
                if (currents[i] > currents[j]) {
                    swpa(currents, i, j);
                }
            }
        }
        return currents;
    }

    /**
     * 快速排序
     * @param currents
     * @param i
     *@param length
     * @return
     */
    private static int[] quicksort(int[] currents, int start, int end){
        if (start<end){
            int i = start, j = end, x = currents[start];
            while (i<j){
                while (i < j && currents[j] >= x)
                    j--;
                if (i < j) {
                    currents[i++] = currents[j];
                }
                while (i < j && currents[i] < x)
                    i++;
                if (i < j)
                    currents[j--] = currents[i];
            }
            currents[start]=x;
            quicksort(currents,start, i - 1);
            quicksort(currents,i+1,end);




        }

        return currents;
    }

    /**
     * 交换
     * @param currents
     * @param i
     * @param j
     */
    private static void swpa(int[] currents, int i, int j) {
        int temp;
        temp = currents[i];
        currents[i] = currents[j];
        currents[j] = temp;
    }


}
