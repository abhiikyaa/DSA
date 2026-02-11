class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row= row;
            this.col = col;
        }
    }
    int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1 && visited[i][0] == false){
                bfs(grid, visited, i, 0);
            }
            if(grid[i][m-1] == 1 && visited[i][m-1] == false){
                bfs(grid, visited, i , m-1);
            }
        }

        for(int j =0; j < m; j++){
            if(grid[0][j] == 1 && visited[0][j] == false){
                bfs(grid, visited, 0, j);
            }
            if(grid[n-1][j] == 1 && visited[n-1][j] == false){
                bfs(grid, visited, n-1, j);
            }
        }

        int count = 0;
        for(int i =0; i < n-1;i++){
            for(int j = 0; j < m-1; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int[][] grid,boolean[][] visited, int r, int c ){
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        visited[r][c] = true;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int[] d : dir){
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1 && visited[nr][nc] == false){
                    visited[nr][nc] = true;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
}