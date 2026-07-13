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
    public int numEnclaves(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++)
        {
            if(grid[i][0] == 1 && !vis[i][0])
            {
                bfs(grid,i,0,vis);
            }
            if(grid[i][m-1] == 1 && !vis[i][m-1])
            {
                bfs(grid,i,m-1,vis);
            }
        }

        for(int j = 0; j < m; j++)
        {
            if(grid[0][j] == 1 && !vis[0][j])
            {
                bfs(grid,0,j,vis);
            }
            if(grid[n-1][j] == 1 && !vis[n-1][j])
            {
                bfs(grid,n-1,j,vis);
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1 && !vis[i][j])
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void bfs(int[][] grid, int r, int c, boolean[][] vis)
    {
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        vis[r][c] = true;
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            for(int[] d : dir)
            {
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1 && !vis[nr][nc])
                {
                    vis[nr][nc] = true;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
}