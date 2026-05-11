// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int[][] dp = new int[n+1][amount+1];
//         for(int i = 0; i <n; i++)
//         {
//             Arrays.fill(dp[i],-1);
//         }
//         for(int i = 1; i <= n; i++)
//         {
//             for(int j = 0; j <= amount; j++)
//             {
//                 dp[i][0] = 0;
//                 dp[0][j] = (int) 1e9;
//                 int take = (int) 1e9;
//                 int nottake = dp[i+1][j];
//                 if(coins[i] <= j)
//                 {
//                     take = dp[i][j-coins[i]] + 1;
//                 }
//                 return dp[i][j] = Math.min(take,nottake);
//             }
//         }
//         int ans = dp[0][amount];
//         if(ans >= (int)1e9){
//             return -1;
//         }
//         else{
//             return ans;
//         }
//     }
// }
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int j = 1; j <= amount; j++) {
            dp[n][j] = (int)1e9; 
        }

        for(int i = n-1; i >= 0; i--) {
            for(int j = 0; j <= amount; j++) {

                int notTake = dp[i+1][j];
                int take = (int)1e9;

                if(coins[i] <= j) {
                    take = 1 + dp[i][j - coins[i]];
                }

                dp[i][j] = Math.min(take, notTake);
            }
        }

        int ans = dp[0][amount];
        if(ans == (int)1e9)
        {
            return -1;
        }
        else
        {
            return ans;
        }
    }
}