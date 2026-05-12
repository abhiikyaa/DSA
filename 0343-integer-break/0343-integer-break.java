class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        if(n == 1) return 1;
        if(n == 2) return 1;
        if(n == 3) return 2;
        for(int i = 4; i <= n; i++)
        {
            for(int j = 1; j < i; j++)
            {
                int x = j;
                int y = i - j;
                int ans1 = x*y;
                int ans2 = x*dp[y];
                int ans3 = dp[x]*y;
                int ans4 = dp[x]*dp[y];

                int final1 = Math.max(ans1,ans2);
                int final2 = Math.max(ans3,ans4);
                dp[i] = Math.max(dp[i],Math.max(final1,final2));
            }
        }
        return dp[n];

    }
}