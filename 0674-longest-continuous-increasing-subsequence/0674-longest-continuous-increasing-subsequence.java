class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return 0;
        int idx = 0;
        int max = 0;

        for(int i = 0; i < n-1; i++)
        {
            if(nums[i] < nums[i+1])
            {
                idx++;
            
            if(idx> max) {
                max = idx;
            }
            }
            else idx = 0;
        }
        return max+1;

    }
}