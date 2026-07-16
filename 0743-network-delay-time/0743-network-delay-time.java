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
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++)
        {
            adj.add(new ArrayList<>());
        }   

        for(int[] t : times)
        {
            int u = t[0];
            int v = t[1];
            int w = t[2];
            adj.get(u).add(new Pair(v,w));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.dist - b.dist);
        pq.add(new Pair(k,0));
        dist[k] = 0;

        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.dist;

            if(d > dist[u]) continue;

            for(Pair nbr : adj.get(u))
            {
                int v = nbr.node;
                int wt = nbr.dist;

                if(dist[v] > dist[u] + wt)
                {
                    dist[v] = dist[u]  + wt;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }
        int t = -1;
        for(int i = 1; i <= n; i++)
        {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            else t = Math.max(t,dist[i]);
        }
        return t;
    }
}