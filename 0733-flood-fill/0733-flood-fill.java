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
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        int n = image.length;
        int m = image[0].length;
        int c = image[sr][sc];
        if(c == color) return image;
        bfs(image,sr,sc,color,c,n,m);
        return image;
    }

    public void bfs(int[][] image, int sr, int sc, int color, int c,int n, int m)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        image[sr][sc] = color;
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            for(int[] d : dir)
            {
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && image[nr][nc] == c )
                {
                    image[nr][nc] = color;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
}
