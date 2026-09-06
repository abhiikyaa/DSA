class Solution {
    public int numDistinct(String s, String t) 
    {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] r : dp)
        {
            Arrays.fill(r,-1);
        }

        return solve(s,t,dp,0,0);
    }

    public int solve(String s, String t, int[][] dp, int i, int j)
    {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int notTake = solve(s,t,dp,i+1,j);
        int take = 0;
        if(s.charAt(i) == t.charAt(j))
        {
            take = solve(s,t,dp,i+1,j+1);
        }
        return dp[i][j] = take + notTake;
    }
}