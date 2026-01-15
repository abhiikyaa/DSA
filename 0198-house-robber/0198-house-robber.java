class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int [nums.length];
        Arrays.fill(dp,-1);
        return MaxAmt(nums, nums.length - 1, dp);
    }
    public int MaxAmt(int[] nums, int n, int[] dp){
        if(n<0) return 0;
        if(n == 0) return nums[0];
        if(n == 1) return Math.max(nums[0] , nums[1]);
        if(dp[n] != -1) return dp[n];

        dp[n] = Math.max(nums[n] + MaxAmt(nums, n-2, dp) , MaxAmt(nums, n - 1 , dp));
        return dp[n];
    }
}