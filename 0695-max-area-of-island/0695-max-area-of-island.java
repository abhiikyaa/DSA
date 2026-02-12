class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int  dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int count = bfs(grid, i, j);
                    max = Math.max(max, count);
                }
            }
        }
        return max;  
    }
    public int bfs(int[][] grid, int r, int c){
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        grid[r][c] = 0;
        int count = 1;

        while(!q.isEmpty()){
            Pair curr = q.poll();

            for(int[] d : dir){
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if(nr >= 0 && nc >=0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                    grid[nr][nc] = 0;
                    q.add(new Pair(nr,nc));
                    count++;
                }
            }
        }
        return count;
    }
    
}