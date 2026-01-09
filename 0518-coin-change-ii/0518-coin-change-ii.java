class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[n] [amount + 1];
        return mcc(n-1, amount, coins, dp);
    }

    public int mcc(int idx, int target, int[] coins, Integer[][] dp){
        if(target == 0){
            return 1;
        }
        if(idx  < 0){
            return 0;
        }
        if(dp[idx][target] != null){
            return dp[idx] [target]; 
        }
        int notpick = mcc (idx - 1, target, coins, dp);
        int pick = 0;
        if(coins[idx] <= target){
            pick = mcc(idx, target - coins[idx], coins, dp);
        }
        return dp[idx] [target] = pick + notpick;
    }
}