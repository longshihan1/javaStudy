package ltttcode;

import java.util.*;

/**
 * 283
 */
public class Movezero {
    public static void main(String args[]) {
        int[] ints = new int[]{0, 1, 0, 3, 12};
        moveZeroes(ints);
    }

    public static void moveZeroes(int[] nums) {
       /* List<Integer> nonZeroElements = new ArrayList<>();
        for (int i = 0; i <nums.length; i++) {
            if (nums[i]!=0){
                nonZeroElements.add(nums[i]);
            }
        }
        for (int i = 0; i <nonZeroElements.size(); i++) {
            nums[i]=nonZeroElements.get(i);
        }
        for (int i = nonZeroElements.size(); i <nums.length; i++) {
            nums[i]=0;
        }*/

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    int temp = nums[k];
                    nums[k++] = nums[i];
                    nums[i] = temp;
                }else {
                    k++;
                }
            }
        }


    }
}