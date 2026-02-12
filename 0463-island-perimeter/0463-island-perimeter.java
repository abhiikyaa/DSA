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
    int p = 0;
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int  i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    bfs(grid, visited, i, j);
                    return p;
                }
            }
        }
        return 0;
    }
    public void bfs(int[][] grid, boolean[][] visited, int r, int c){
        Queue <Pair> q =new LinkedList<>();
        q.add(new Pair(r,c));
        visited[r][c] = true;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int[] d : dir){
                int nr =curr.row + d[0];
                int nc = curr.col + d[1];

                if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] == 0 ){
                    p++;
                }
                else if(visited[nr][nc] == false){
                    visited[nr][nc] = true;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
}