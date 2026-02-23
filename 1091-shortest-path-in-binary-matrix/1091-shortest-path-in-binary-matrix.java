class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int[][] dir = {{0,1},{1,0},{-1,0}, {0,-1},{-1,-1}, {-1,1}, {1,-1}, {1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int  n =grid.length;
        int  m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        if(grid[0][0] == 1 || grid[n-1][m-1] == 1){
            return -1;
        }
        return bfs(grid, vis, 0, 0);
    }
    public int bfs (int[][] grid, boolean[][] vis, int r, int c){
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        vis[r][c] = true;
        int count = 1;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size;i++){
                Pair curr = q.poll();
                if(curr.row == grid.length - 1 && curr.col == grid[0].length - 1){
                    return count;
                }

                for(int[] d : dir){
                    int nr = curr.row + d[0];
                    int nc = curr.col + d[1];

                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 0 && !vis[nr][nc]){
                        vis[nr][nc] = true;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
            count++;
        }
        return -1;
    }
}