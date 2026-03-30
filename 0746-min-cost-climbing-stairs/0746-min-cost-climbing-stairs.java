class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, cost, dp);
    }

    private int helper(int i, int[] cost, int[] dp) {
        if (i == 0 || i == 1) return 0;

        if (dp[i] != -1) return dp[i];

        dp[i] = Math.min(
            cost[i - 1] + helper(i - 1, cost, dp),cost[i - 2] + helper(i - 2, cost, dp));

        return dp[i];
    }
}