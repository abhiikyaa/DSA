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
    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int c = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == '1' && !vis[i][j])
                {
                    c++;
                    bfs(grid,vis,i,j,n,m);
                }
            }
        }
        return c;
    }

    public void bfs(char[][] grid,boolean[][] vis,int i, int j, int n, int m)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j] = true;

        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;

            for(int[] d : dir)
            {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == '1' && !vis[nr][nc])
                {
                    grid[nr][nc] = '0';
                    vis[nr][nc] = true;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
}