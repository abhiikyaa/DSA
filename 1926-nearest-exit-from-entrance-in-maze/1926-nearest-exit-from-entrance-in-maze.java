class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(entrance[0],entrance[1]));
        maze[entrance[0]][entrance[1]] = '+';

        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int i = 0; i < size; i++){
                Pair curr = q.poll();
                for(int[] d : dir){
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && maze[nr][nc] == '.'){
                    if(nr == 0 || nc == 0 || nr == n-1 || nc == m-1){
                        return count;
                    }
                    maze[nr][nc] = '+';
                    q.add(new Pair(nr,nc));
                }
                }  
            }
            
        }
        return -1;
        
    }
}