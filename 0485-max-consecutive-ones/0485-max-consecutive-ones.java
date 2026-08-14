class Solution {
    public int findMaxConsecutiveOnes(int[] nums) 
    {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int ans = 0;

        while(r < n)
        {
            if(nums[r] == 1)
            {
                r++;
                ans = Math.max(ans,r-l);
            }
            else
            {
                r++;
                l = r;
            }
        }
        return ans;

    }
}