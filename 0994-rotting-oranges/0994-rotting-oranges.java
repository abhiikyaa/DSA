class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshorange = 0;
        int time = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i] [j] == 2){
                    q.add(new int[]{i, j , 0});
                }
                if(grid[i] [j] == 1){
                    freshorange++;
                }

            }
        }
        if(freshorange == 0) return 0;
        int[][] dr = {{0,-1}, {-1,0}, {0,1}, {1,0}};

        while(!q.isEmpty()){
            int qsize = q.size();
            boolean rotted = false;
            for (int k = 0; k < qsize; k++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int i = 0; i < 4; i++){
                    int nr = r + dr[i][0];
                    int nc = c + dr[i][1];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        freshorange--;
                        q.add(new int[]{nr,nc});
                        rotted = true;
                    }
                }
            }
            if (rotted) time++;
        }
        if (freshorange == 0) {
            return time;
        }else{
            return -1;
        }

    }
}