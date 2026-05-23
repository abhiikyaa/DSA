class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int c = 0;
        for(int i = 1; i < n; i++)
        {
            if(nums[i] < nums[i-1])
            {
                c++;
            }
        }
        if(nums[0] < nums[n-1])
            {
                c++;
            }
        if(c < 2)
        {
            return true;
        }
        return false;
    }
}