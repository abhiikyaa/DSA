class Solution {
    public int lengthOfLIS(int[] nums) 
    {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i= 0; i < n; i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return solve(0,-1,nums,dp);
    }

    public int solve(int i, int j, int[] arr, int[][] dp)
    {
        if(i == arr.length)
        {
            return 0;
        }

        if(dp[i][j+1] != -1)
        {
            return dp[i][j+1];
        }

        int take = 0;
        int skip = solve(i+1,j,arr,dp);
        if(j == -1 || arr[i] > arr[j])
        {
            take = 1 + solve(i+1,i,arr,dp);
        }

        return dp[i][j+1] = Math.max(take,skip);
    }
}