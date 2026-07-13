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
    public int largestIsland(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        boolean zero = false;
        HashMap<Integer,Integer> mp = new HashMap<>();
        int id=2;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1)
                {
                    int count = bfs(grid,i,j,id);
                    mp.put(id,count);
                    max = Math.max(max,count);
                    id++;
                }
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 0)
                {
                    zero = true;
                    HashSet<Integer> s =new HashSet<>();
                    int size = 1;
                    for(int []d:dir){
                        int nr=d[0]+i;
                        int nc=d[1]+j;
                        if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] > 1)
                        {
                            int key = grid[nr][nc];
                            if(!s.contains(key))
                            {
                                s.add(key);
                                size += mp.get(key);
                            }
                        }
                        
                        
                    }
                    max=Math.max(max,size);
                   
                }
            }
        }
        
        if(max==0){ 
            return n*m;
        }
        return max;
    
        
    }
    public int bfs(int[][] grid, int r, int c,int id)
    {
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        grid[r][c] = id;
        int count = 1;
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            for(int[] d : dir)
            {
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1)
                {
                    grid[nr][nc] = id;
                    q.add(new Pair(nr,nc));
                    count++;
                }
            }
        }
        return count;
    }
}