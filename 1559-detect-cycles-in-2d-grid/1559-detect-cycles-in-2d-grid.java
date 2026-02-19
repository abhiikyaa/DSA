class Solution {
    class Pair{
        int row;
        int col;
        int prtR;
        int prtC;
        Pair(int row, int col, int prtR, int prtC){
            this.row = row;
            this.col = col;
            this.prtR = prtR;
            this.prtC = prtC;
        }
    }
    int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == false){
                    if(bfs(i,j,grid,vis)){
                        return true;
                    }
                }
            }
        }
        return false;        
    }
    public boolean bfs( int r, int c,char[][] grid,boolean[][] vis){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c,-1,-1));
        vis[r][c] = true;

        while(!q.isEmpty()){
            Pair curr = q.poll();

            for(int[] d : dir){
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == grid[curr.row][curr.col]){
                    if(vis[nr][nc] == false){
                        vis[nr][nc] = true;
                        q.add(new Pair(nr,nc,curr.row, curr.col));
                    }
                    else if(nr != curr.prtR || nc != curr.prtC){
                        return true;
                    }    
                }
            }

        }
        return false;
    }
}