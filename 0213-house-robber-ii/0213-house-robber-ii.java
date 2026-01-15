class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[] dp1 = new int [n];
        Arrays.fill(dp1,-1);
        int case1 =  MaxAmt(nums, n-2, dp1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2,-1);
        int case2 =  MaxAmt2(nums,n-1,dp2);

        return Math.max(case1,case2);
    }
    public int MaxAmt(int[] nums, int n, int[] dp){
        if(n<0) return 0;
        if(n == 0) return nums[0];
        if(n == 1) return Math.max(nums[0] , nums[1]);
        if(dp[n] != -1) return dp[n];

        dp[n] = Math.max(nums[n] + MaxAmt(nums, n-2, dp) , MaxAmt(nums, n - 1 , dp));
        return dp[n];
    }
    public int MaxAmt2(int[] nums, int n , int[] dp){
        if(n < 1) return 0;
        if(n == 1) return nums[1];
        if(n == 2) return Math.max(nums[1] , nums[2]);
        if(dp[n] != -1) return dp[n];

        dp[n] = Math.max(nums[n] + MaxAmt2(nums, n-2, dp) , MaxAmt2(nums, n - 1 , dp));
        return dp[n];

    }
}