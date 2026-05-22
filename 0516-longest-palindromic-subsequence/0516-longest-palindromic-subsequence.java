class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
         return solve(s,0,n-1,dp);
    }
    public int solve(String s, int i, int j, int[][] dp)
    {
        if(i == j) return 1;
        if(i > j) return 0;

        if(dp[i][j] != 0) return dp[i][j];
        int take = 0;
        int skip = Math.max(solve(s,i,j-1,dp),solve(s,i+1,j,dp));
        if(s.charAt(i) == s.charAt(j))
        {
            take = 2 + solve(s, i+1 , j-1, dp);
        }
        return dp[i][j] = Math.max(take,skip);
    }
}