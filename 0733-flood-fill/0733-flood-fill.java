class Solution {
    class Pair
    {
        int row;
        int col;
        Pair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        int c = image[sr][sc];
        if(c == color)
        {
            return image;
        }
        bfs(image,sr,sc,c,color,vis);
        return image;
    }

    public void bfs(int[][] image, int sr, int sc,int c, int newc, boolean[][] vis)
    {
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        vis[sr][sc] = true;
        image[sr][sc] = newc;
        
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            for(int[] d : dir )
            {
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];
                
                if(nr >= 0 && nc >= 0 && nr < image.length && nc < image[0].length && !vis[nr][nc] && image[nr][nc] == c)
                {
                    vis[nr][nc] = true;
                    image[nr][nc] = newc;
                    q.add(new Pair(nr,nc));
                    
                }
            }
        }
    }
    
}
