package ltttcode;

/**
 * 75
 */
public class SortColor {
    public static void main(String args[]) {

    }

    public void sortColors(int[] nums) {

      /*  int[] count = new int[]{0, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            assert (nums[i] >= 0 && nums[i] <= 2);
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }*/

        int zero = -1;
        int two=nums.length;
        for (int i = 0; i <two; i++) {
            if (nums[i]==1){
                i++;
            }else if (nums[i]==2){
                int temp = nums[i];
                nums[i] = nums[--two];
                nums[two] = temp;
            }else {
              //swap(num[++zero],num[i++])
            }
        }
    }
}
