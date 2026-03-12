class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int size = bfs(grid, vis, i ,j);
                    if(size > 1){
                        ans += size;
                    }
                }
            }
        }
        return ans;
    }
    private int bfs(int[][] grid, boolean[][] vis, int r, int c){
        int n = grid.length;
        int m = grid[0].length;
        Queue <Pair> q = new LinkedList<>();
        q.offer(new Pair(r,c));
        vis[r][c] = true;

        int count = 1;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int nr = curr.r;
            int nc = curr.c;

            for(int i = 0; i < n; i++){
                if(grid[i][nc] == 1 && !vis[i][nc]){
                    vis[i][nc] = true;
                    q.offer(new Pair(i,nc));
                    count++;
                }
            }
            for(int j = 0; j < m; j++){
                if(grid[nr][j] == 1 && !vis[nr][j]){
                    vis[nr][j] = true;
                    q.offer(new Pair(nr,j));
                    count++;
                }
            }
        }
        return count;
    }
}