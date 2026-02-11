class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[][] dir = {{0,1}, {0,-1}, {-1,0}, {1,0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int originalColor = image[sr][sc];
        if (originalColor == color) return image;

        boolean[][] visited = new boolean[n][m];
        bfs(visited, image, sr, sc, originalColor, color);
        return image;
    }

    public void bfs(boolean[][] visited, int[][] image,
                    int sr, int sc, int originalColor, int newColor) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        visited[sr][sc] = true;
        image[sr][sc] = newColor;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (int[] d : dir) {
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && !visited[nr][nc] && image[nr][nc] == originalColor) {
                    visited[nr][nc] = true;
                    image[nr][nc] = newColor;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}
