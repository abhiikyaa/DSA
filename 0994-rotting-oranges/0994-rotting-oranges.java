class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;

        int r  = grid.length;
        int c = grid[0].length;
        int[][] t = new int [r][c];
        for(int i = 0; i < r; i++){
            Arrays.fill(t[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 2){
                    dfs(grid, t , i, j , 0);
                }
            }
        }
        int totaltime = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j< c; j++){
                if(grid[i][j] == 1){
                    if(t[i][j] == Integer.MAX_VALUE){
                        return -1;
                    }
                    totaltime = Math.max(totaltime, t[i][j]);
                }
            }
        }
        return totaltime;
    }
    private void dfs(int[][] grid, int[][] t, int i, int j, int currenttime){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || currenttime >= t[i][j]){
            return;
        }
        t[i][j] = currenttime;
        dfs(grid, t , i-1, j, currenttime + 1);
        dfs(grid, t , i+1, j, currenttime + 1);
        dfs(grid, t , i, j-1, currenttime + 1);
        dfs(grid, t , i, j+1, currenttime + 1);
    }
}