class Solution {
    class Pair
    {
        int node;
        int dist;
        Pair(int node, int dist)
        {
            this.node = node;
            this.dist = dist;
        }
    }
    public int minScore(int n, int[][] roads) 
    {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] r : roads)
        {
            int u = r[0];
            int v = r[1];
            int wt = r[2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }

        boolean[] vis = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1] = true;
        int ans = (int)1e9;

        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(Pair nbr : adj.get(curr))
            {
                if(!vis[nbr.node])
                {
                    vis[nbr.node] = true;
                    q.add(nbr.node);
                }
                ans = Math.min(ans,nbr.dist);

            }

        }
        return ans;

    }
}