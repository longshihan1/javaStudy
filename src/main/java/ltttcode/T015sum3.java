package ltttcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T015sum3 {

    public static void main(String[] args) {

        System.out.println("" + threeSum(new int[]{-4, -1, -1, 0, 1, 2}));
    }

    public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(num);

        for(int k = 0; k < num.length - 2; k++) {
            int i = k + 1;
            int j = num.length - 1;
            int target = 0 - num[k];
            while(i < j) {
                if(num[i]+ num[j] == target) {
                    lists.add(Arrays.asList(num[k], num[i++], num[j--]));
                    while(i < j && num[i] == num[i - 1]) i++;
                    while(i < j && num[j] == num[j + 1]) j--;
                }
                else if(num[i]+ num[j] < target) i++;
                else j--;
            }
            // Skip duplicates(keep skipping until num[k+1] != k), remember, the for loop will add 1 to k, so that next num[k]
            // won't be a duplicate
            while(k < num.length - 2 && num[k] == num[k+1])
                k++;
        }

        return lists;

    }

    public static List<Integer> threeSum(int[] nums,int left,int hight) {
        List<Integer> bodyList = new ArrayList<>();
        if (left<hight){
            for (int i = left+1; i <hight; i++) {
                if (nums[left]+nums[i]+nums[hight]==0){
                    System.out.println("left:"+left+":"+nums[left]+",current:"+i+":"+nums[i]+",right:"+hight+":"+nums[hight]);
//                    bodyList.add(nums[left]);
//                    bodyList.add(nums[i]);
//                    bodyList.add(nums[hight]);
                }
            }
            threeSum(nums,left+1,hight);
            threeSum(nums,left,hight-1);
        }
        return bodyList;
    }

}
