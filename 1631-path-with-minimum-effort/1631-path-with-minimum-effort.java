class Solution {
    class Pair
    {
        int row;
        int col;
        int height;
        Pair(int row, int col, int height)
        {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int minimumEffortPath(int[][] heights) 
    {
        int n = heights.length;
        int m = heights[0].length;  
        int[][] dist = new int[n][m];
        for(int[] r : dist)
        {
            Arrays.fill(r,Integer.MAX_VALUE);
        } 
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.height - b.height);
        pq.add(new Pair(0,0,0));
        dist[0][0] = 0;

        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            int h = curr.height;

            if(r == n-1 && c == m-1) return h;
            for(int[] d : dir)
            {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m)
                {
                    int ans = Math.max(h, Math.abs(heights[r][c] - heights[nr][nc]));
                    if(ans < dist[nr][nc])
                    {
                        dist[nr][nc] = ans;
                        pq.add(new Pair(nr,nc,ans));
                    }
                }
            }
        }
        return 0;
    }
}
