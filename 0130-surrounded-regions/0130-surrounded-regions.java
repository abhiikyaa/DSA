class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                bfs(board, 0, j, visited);
            }
            if (board[n-1][j] == 'O' && !visited[n-1][j]) {
                bfs(board, n-1, j, visited);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                bfs(board, i, 0, visited);
            }
            if (board[i][m-1] == 'O' && !visited[i][m-1]) {
                bfs(board, i, m-1, visited);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(char[][] board, int r, int c, boolean[][] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (int[] d : dir) {
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 'O' && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}
