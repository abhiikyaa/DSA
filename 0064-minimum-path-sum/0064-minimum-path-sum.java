class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
        Arrays.fill(dp[i],-1);
        }
        return solve(n-1,m-1,grid,dp);
    }

    public int solve(int i, int j ,int[][] arr, int[][] dp){
        if(i < 0 || j < 0) return (int)1e9;
        if(dp[i][j] != -1) return dp[i][j];
        if(i ==0 && j ==0) return arr[0][0];
        int right = solve(i-1,j,arr,dp);
        int down = solve(i,j-1,arr,dp);
        dp[i][j] = arr[i][j] + Math.min(right,down);
        return dp[i][j];
    }
}