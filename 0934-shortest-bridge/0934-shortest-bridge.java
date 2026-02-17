class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        Queue <Pair> q = new LinkedList<>();
        boolean found = false;


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    dfs(grid, vis , i , j , n, m, q);
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }
        
    
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                

            
            Pair curr = q.poll();

            for(int[] d : dir){
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

            if(nr >=0 && nc >= 0 && nr < grid.length && nc < grid[0].length && !vis[nr][nc]){
                    if(grid[nr][nc] == 1){
                        return count;
                    }
                    q.add(new Pair(nr,nc));
                    vis[nr][nc] = true;
                }
            }
            }
            count++;
        }
        return -1; 
    }
    public void dfs (int[][] grid, boolean[][] vis, int i, int j , int r , int c ,Queue <Pair> q){
        if(i < 0 || j < 0 || i > r-1 || j > c-1 || grid[i][j] == 0 || vis[i][j]){
            return;
        }
        vis[i][j] = true;
        q.add(new Pair(i,j));

        for(int[] d : dir){
            int nr = i + d[0];
            int nc = j + d[1];

            dfs(grid, vis, nr, nc, r, c, q);
        }

    }
}