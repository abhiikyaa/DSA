class Solution {
    class Pair
    {
        int row;
        int col;
        int time;
        Pair(int row, int col, int time)
        {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        int fo = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                }
                else if(grid[i][j] == 1)
                {
                    fo++;
                }
            }
        }
        int ans = bfs(grid,q,fo,n,m);
        return ans;

    }

    private int bfs(int[][] grid, Queue<Pair> q, int fo, int n, int m)
    {
        int t = 0;
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            t = curr.time;

            for(int[] d : dir)
            {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1)
                {
                    grid[nr][nc] = 2;
                    fo--;
                    q.add(new Pair(nr,nc,t+1));
                }
            }
        }
        if(fo == 0) return t;
        else return -1;
    }
}