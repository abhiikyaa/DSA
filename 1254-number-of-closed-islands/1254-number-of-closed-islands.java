class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n;i++){
            if(grid[i][0] == 0 && visited[i][0] == false){
                bfs(grid, visited, i , 0);
            }
            if(grid[i][m-1] == 0 && visited[i][m-1] == false){
                bfs(grid, visited, i, m-1);
            }

        }

        for(int j = 0; j < m; j++){
            if(grid[0][j] == 0 && visited[0][j] == false){
                bfs(grid, visited, 0 , j);
            }
            if(grid[n-1][j] == 0 && visited[n-1][j] == false){
                bfs(grid, visited, n-1, j);
            }
        }

        int count = 0;
        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < m-1; j++){
                if(grid[i][j] == 0 && visited[i][j] == false){
                    count++;
                    bfs(grid, visited, i ,j);
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
                int newR = curr.row + d[0];
                int newC = curr.col + d[1];

                if(newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == 0 && visited[newR][newC] == false){
                    visited[newR][newC] = true;
                    q.add(new Pair(newR,newC));
                }
            }
        }
    }
}