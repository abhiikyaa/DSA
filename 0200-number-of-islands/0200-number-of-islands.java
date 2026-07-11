class Solution {
    class Pair
    {
        int row;
        int col;
        Pair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == '1' && vis[i][j] == false)
                {
                    bfs(grid,i,j,vis);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int r, int c, boolean[][] vis)
    {
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        vis[r][c] = true;
        grid[r][c] = '0';
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            for(int[] d : dir)
            {
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1' && vis[nr][nc] == false)
                {
                    grid[nr][nc] = '0';
                    vis[nr][nc] = true;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
}