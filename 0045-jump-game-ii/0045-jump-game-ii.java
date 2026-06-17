class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }

    public int solve(int i, int[] nums, int[] dp)
    {
        if(i >= nums.length-1) return 0;
        if(dp[i] != -1) return dp[i];
        int min = (int)1e9;
        int take = 0;
        for(int j = 1; j <= nums[i] && i+j < nums.length; j++)
        {
            take = 1 + solve(i+j,nums,dp);
            min = Math.min(min,take);
        }
        return dp[i] = min;
    }
}
