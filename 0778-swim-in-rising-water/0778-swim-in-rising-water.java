class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row,int col, int dist){
            this.row= row;
            this.col = col;
            this.dist = dist;
        }
    }
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m =grid[0].length;
        int ans[][] = new int [n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(ans[i],Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        ans[0][0] = grid[0][0];
        pq.add(new Pair(0,0,grid[0][0]));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int t = curr.dist;
            if (curr.row == n-1 && curr.col == m-1){
                return t;
            }

            for(int[] d : dir){
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m){
                    int time = Math.max(t,grid[nr][nc]);
                    if(time < ans[nr][nc]){
                        ans[nr][nc] = time;
                        pq.add(new Pair(nr,nc,time));
                    }
                }
            }
        }
        return -1;


        
    }
}