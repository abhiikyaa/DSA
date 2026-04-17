class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum%2 != 0) return false;;
        Boolean[][] dp = new Boolean[nums.length+1][(sum/2)+1];
        return helper(nums,0,sum/2,dp);
    }
    public boolean helper(int[] nums, int i, int t, Boolean[][] dp){
        if(t == 0) return true;
        if(i >= nums.length || t < 0) return false;
        if(dp[i][t] != null) return dp[i][t];

        dp[i][t] = (helper(nums,i+1,t - nums[i], dp) || helper(nums,i+1,t , dp));
        return dp[i][t];

    }
}