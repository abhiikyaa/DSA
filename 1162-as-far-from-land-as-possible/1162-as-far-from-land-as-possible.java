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
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dist = 0;
        int distance = 0;
        Queue <Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i,j));
                }
            }
        }
        if(q.isEmpty() || q.size() == n * m) return -1;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int[] d : dir){
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 0){
                    q.add(new Pair(nr,nc));
                    grid[nr][nc] = grid[curr.row][curr.col] + 1;
                    distance = grid[nr][nc];
                    distance -= 1;
                }
            }
        }
        return dist = Math.max(dist, distance);
    }
}