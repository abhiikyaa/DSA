class Solution {
    static int INF = (int)1e9;
    public int jump(int[] nums) 
    {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return solve(nums,0,dp);
    }

    public int solve(int[] nums, int i, int[] dp)
    {
        if(i >= nums.length-1) return 0;
        if(dp[i] != -1) return dp[i];
        int min = INF;
        for(int j = 1; j <= nums[i] && i+j < nums.length; j++)
        {
            int take = 1 + solve(nums,i+j,dp);
            min = Math.min(min,take);
        }
        return dp[i] = min;
    }
}