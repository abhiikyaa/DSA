class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int direction[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    int count = 0;
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    count++;
                    bfs(visited, grid, i, j , n , m);
                }
            }
        }
        return count;
    }
    public void bfs(boolean[][] visited,char[][] grid, int currRow, int currCol, int tRow, int tCol){
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(currRow, currCol));
        visited[currRow][currCol] = true;

        while(!q.isEmpty()){
            Pair curr = q.poll();

            for(int[] dir : direction){
                int nRow = curr.row + dir[0];
                int nCol = curr.col + dir[1];

                if (nRow >= 0 && nRow < tRow && nCol >= 0 && nCol < tCol &&grid[nRow][nCol] == '1' && !visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    q.add(new Pair(nRow, nCol));
                }
            }    
        }      
    }
}