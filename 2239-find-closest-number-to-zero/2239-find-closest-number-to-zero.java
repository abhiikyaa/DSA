class Solution {
    public int findClosestNumber(int[] nums) 
    {
        int n = nums.length;
        int ans = nums[0];

        for(int i = 1; i < n; i++)
        {
            int min = Math.abs(nums[i]);

            if(min < Math.abs(ans))
            {
                ans = nums[i];
            }
            else if(min == Math.abs(ans) && nums[i] > ans)
            {
                ans = nums[i];
            }
        }

        return ans;
    }
}