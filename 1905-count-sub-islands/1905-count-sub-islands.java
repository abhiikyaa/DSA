class Solution {
    class Pair {
        int row, col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length;
        int m = grid2[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    if (bfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean bfs(int[][] grid1, int[][] grid2, int r, int c) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        grid2[r][c] = 0; 

        boolean isSubIsland = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (grid1[curr.row][curr.col] == 0) {
                isSubIsland = false;
            }

            for (int[] d : dir) {
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if (nr >= 0 && nc >= 0 && nr < grid2.length && nc < grid2[0].length && grid2[nr][nc] == 1) {
                    grid2[nr][nc] = 0;
                    q.add(new Pair(nr, nc));
                }
            }
        }
        return isSubIsland;
    }
}
