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
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue <Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isWater[i][j] == 1){
                    isWater[i][j] = 0;
                    q.add(new Pair(i,j));
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Pair curr = q.poll();

            for(int[] d : dir){
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if(nr >= 0 && nc >= 0 && nr < isWater.length && nc < isWater[0].length && isWater[nr][nc] == 0 && !visited[nr][nc]){
                    isWater[nr][nc] = isWater[curr.row][curr.col] + 1;
                    q.add(new Pair(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
        return isWater;
    }
}