class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long dp1[][] = new long[n][m];
        long dp2[][] = new long[n][m];
        dp1[0][0] = grid[0][0];
        dp2[0][0] = grid[0][0]; 

        for(int i = 1; i < n; i++){
            dp1[i][0] = dp1[i-1][0] * grid[i][0];
            dp2[i][0] = dp1[i][0];
        }

        for(int j = 1; j < m; j++){
            dp1[0][j] = dp1[0][j-1] * grid[0][j];
            dp2[0][j] = dp1[0][j];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                long val = grid[i][j];
                long a = dp1[i-1][j] * val;
                long b = dp1[i][j-1] * val;
                long c = dp2[i-1][j] * val;
                long d = dp2[i][j-1] * val;

                dp1[i][j] = Math.max(Math.max(a,b),Math.max(c,d));
                dp2[i][j] = Math.min(Math.min(a,b),Math.min(c,d));

            }
        }

        long ans = dp1[n-1][m-1];
        long mod = 1000000007;

if(ans < 0){
    return -1;
}
else{
    return (int)(ans % mod);
}
    }
}