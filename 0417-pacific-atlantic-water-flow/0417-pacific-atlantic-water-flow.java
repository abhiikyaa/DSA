import java.util.*;

class Solution {

    class Pair {
        int row, col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];

        Queue<Pair> pacQueue = new LinkedList<>();
        Queue<Pair> atlQueue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            pac[i][0] = true;
            pacQueue.add(new Pair(i, 0));
        }

        for(int j = 0; j < m; j++){
            pac[0][j] = true;
            pacQueue.add(new Pair(0, j));
        }

        for(int i = 0; i < n; i++){
            atl[i][m-1] = true;
            atlQueue.add(new Pair(i, m-1));
        }

        for(int j = 0; j < m; j++){
            atl[n-1][j] = true;
            atlQueue.add(new Pair(n-1, j));
        }

        bfs(heights, pacQueue, pac);
        bfs(heights, atlQueue, atl);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pac[i][j] && atl[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Queue<Pair> q, boolean[][] visited) {

        int n = heights.length;
        int m = heights[0].length;

        while(!q.isEmpty()){

            Pair curr = q.poll();

            for(int[] d : dir){
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m
                        && !visited[nr][nc]
                        && heights[nr][nc] >= heights[curr.row][curr.col]){

                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}
