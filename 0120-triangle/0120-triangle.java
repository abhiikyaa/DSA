class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        Integer[][] dp = new Integer[n][n];
        return solve(0, 0, n, triangle, dp);
    }

    public int solve(int i, int j, int n, List<List<Integer>> triangle, Integer[][] dp) {
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }
        
        if (dp[i][j] != null) return dp[i][j];

        int left = solve(i + 1, j, n, triangle, dp);
        int right = solve(i + 1, j + 1, n, triangle, dp);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(left, right);
    }
}