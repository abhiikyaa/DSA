class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges)
        {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return bfs(source,destination,adj);
    }

    public boolean bfs( int s, int t, ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[adj.size()];
        q.add(s);
        vis[s] = true;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            if(curr == t) return true;

            for(int nbr : adj.get(curr))
            {
                if(vis[nbr] == false)
                {
                    vis[nbr] = true;
                    q.add(nbr);
                }
            }
        }
        return false;
        
        

    }
    
}