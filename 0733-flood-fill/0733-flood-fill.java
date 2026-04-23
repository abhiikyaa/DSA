class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalcolor = image[sr][sc];
        if(originalcolor == color) return image;

        dfs(image, sr, sc, originalcolor, color);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int originalcolor, int newcolor){
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length  || image[r][c] != originalcolor){
            return;
        }

        image[r][c] = newcolor;

        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];
            dfs(image, nr, nc, originalcolor, newcolor);
        }
    }
}