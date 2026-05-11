class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0; i < n; i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return sol(0,amount,coins,dp);
    }

    public int sol(int i, int j, int[] coins,int[][] dp)
    {
        if(j == 0)
        {
            return 1;
        }
        if(i < 0)
        {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int take = 0;
        int skip = sol(i+1,j,coins,dp);
        if(coins[i] <= j)
        {
            take = sol(i,j-coins[i],coins,dp);
        }
        return dp[i][j] = take + skip;
    }
}