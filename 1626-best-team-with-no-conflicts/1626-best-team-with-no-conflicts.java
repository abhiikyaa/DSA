class Solution {
    public int bestTeamScore(int[] scores, int[] ages) 
    {
        int n = scores.length;
        int[][] dp = new int[n][n+1];
        for(int i = 0; i < n; i++)
        {
            Arrays.fill(dp[i],-1);
        }
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            arr[i][0] = scores[i];
            arr[i][1] = ages[i];
        }
        Arrays.sort(arr,(a,b)->{if(a[1] == b[1]) return a[0] - b[0]; return a[1] - b[1];});

        return solve(arr,n-1,-1,dp);
    }

    public int solve(int[][] arr, int idx, int prev, int[][] dp)
    {
        if(idx < 0) return 0;
        if(dp[idx][prev+1] != -1)
        {
            return dp[idx][prev+1];
        }
        int take = 0;
        int skip = solve(arr,idx-1,prev,dp);
        if(prev == -1 || arr[idx][0] <= arr[prev][0])
        {
            take = arr[idx][0] + solve(arr,idx-1,idx,dp);
        }
        return dp[idx][prev+1] = Math.max(take,skip);
    }
}
