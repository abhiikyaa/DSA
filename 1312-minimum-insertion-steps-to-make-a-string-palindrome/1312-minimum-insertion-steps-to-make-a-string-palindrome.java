class Solution 
{
    public int minInsertions(String s)
    {
        int n = s.length();
        int[][] dp = new int[n][n];
        int len = solve(s,0,n-1,dp,n);
        return n-len;
    }

    public int solve(String s, int i, int j, int[][] dp,int n)
    {
        if(i == j) return 1;
        if(i > j) return 0;
        if(dp[i][j] != 0) return dp[i][j];

        int take = 0;
        if(s.charAt(i) == s.charAt(j))
        {
            take = 2 + solve(s,i+1,j-1,dp,n);
        }
        int skip = Math.max(solve(s,i,j-1,dp,n),solve(s,i+1,j,dp,n));

        dp[i][j] = Math.max(take,skip);
        return dp[i][j];
    }
}