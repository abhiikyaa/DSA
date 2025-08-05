import java.util.Arrays;

public class colorsorting {
    public void sortColors(int[] nums) {
        int l = 0;
        int m = 0;
        int r = nums.length - 1;
        while (m <= r) {
            if (nums[m] == 0) {
                swap(nums,l,m);
                l++;
                m++;
            }
            else if (nums[m] == 1) {
                m++;
            }
            else {
                swap (nums,m,r);
                r--;
            }
        }
    }    
    public void swap (int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        colorsorting obj = new colorsorting();
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    
}
