import java.util.*;

class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair> q = new LinkedList<>();

       
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i, j));
                } else {
                    mat[i][j] = -1;  
                }
            }
        }

       
        while(!q.isEmpty()){

            Pair curr = q.poll();

            for(int[] d : dir){
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && mat[nr][nc] == -1){

                    mat[nr][nc] = mat[curr.row][curr.col] + 1;

                    q.add(new Pair(nr, nc));
                }
            }
        }

        return mat;
    }
}
