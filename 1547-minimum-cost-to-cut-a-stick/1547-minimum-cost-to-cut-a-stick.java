class Solution {
    public int minCost(int n, int[] cuts) 
    {
        int m = cuts.length;
        int[] arr = new int[m+2];
        arr[0] = 0;
        arr[m+1] = n;
        for(int i = 0; i < m; i++)
        {
            arr[i+1] = cuts[i];
        }
        Arrays.sort(arr);
        int[][] dp = new int[m+1][m+1];
        for(int[] r : dp)
        {
            Arrays.fill(r,-1);
        }   

        return solve(arr,1,m,dp);
    }
    public int solve(int[] arr, int i, int j, int[][] dp)
    {
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++)
        {
            int left = solve(arr,i,k-1,dp);
            int right = solve(arr,k+1,j,dp);
            int min = arr[j+1] - arr[i-1]+left+right;

            ans = Math.min(ans,min);
        }
        return dp[i][j] = ans;
    }
}