class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i++)
        {
            Arrays.fill(dp[i],-1);
        }
        int ans = solve(coins,n-1,amount,dp);
        if(ans >= (int) 1e9){
            return -1;
        }else return ans;
    }
    public int solve(int[] coins, int i, int j, int[][] dp)
    {
        if(j == 0) return 0;
        if(i < 0) return (int) 1e9;
        
        if(dp[i][j] != -1) return dp[i][j];

        int take = (int) 1e9;
        int nottake = solve(coins,i-1,j,dp);
        if(coins[i] <= j)
        {
            take = 1 + solve(coins,i,j-coins[i],dp);
        }
        return dp[i][j] = Math.min(take , nottake);
    }
}