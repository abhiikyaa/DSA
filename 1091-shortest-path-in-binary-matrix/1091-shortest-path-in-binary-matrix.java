class Solution {
    class Pair
    {
        int row;
        int col;
        int dist;
        Pair(int row, int col, int dist)
        {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        return bfs(grid,0,0,1,vis);
    }

    public int bfs(int[][] grid, int r, int c, int t, boolean[][] vis)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c,t));
        vis[r][c] = true;
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            if(curr.row == grid.length-1 && curr.col == grid[0].length-1) return curr.dist;
            for(int[] d : dir)
            {
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 0 && !vis[nr][nc])
                {
                    vis[nr][nc] = true;
                    q.add(new Pair(nr,nc,curr.dist+1));
                }
            }
        }
        return -1;
    }
}