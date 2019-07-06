package ltttcode;

public class T011Container {

    public static void main(String[] args) {

        System.out.println(""+maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }


    public static int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        while (right>left){
            if (height[right]>height[left]){
                max=max>height[left]*(right-left)?max:height[left]*(right-left);
                left++;
            }else {
                max=max>height[right]*(right-left)?max:height[right]*(right-left);
                right--;
            }
        }
        return max;
    }
}
