class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int c = 0;
        for(int i = 0; i < n; i++)
        {
            if(vis[i] != true)
            {
                c++;
                bfs(isConnected,vis,i);
            }
        }
        return c;
    }

    public void bfs(int[][] isConnected, boolean[] vis, int i)
    {
        Queue <Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(int nbr = 0; nbr < isConnected.length; nbr++)
            {
                if(isConnected[curr][nbr] == 1 && vis[nbr] == false)
                {
                    q.add(nbr);
                    vis[nbr] = true;
                }
            }
        }
    }
}