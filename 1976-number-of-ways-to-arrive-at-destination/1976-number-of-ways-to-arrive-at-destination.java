class Solution {

    class Pair {
        int node;
        long dist;

        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        long[] dist = new long[n];
        int[] way = new int[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Long.compare(a.dist , b.dist));
        pq.add(new Pair(0,0));
        dist[0] = 0;
        way[0] = 1;
        int MOD =1000000007;
        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            int u = curr.node;
            long d = curr.dist;

            if(d > dist[u]) continue;

            for(Pair nbr : adj.get(u))
            {
                int v = nbr.node;
                long wt = nbr.dist;

                if(dist[v] > dist[u] + wt)
                {
                    dist[v] = dist[u] + wt;
                    way[v] = way[u];
                    pq.add(new Pair(v,dist[v]));
                }

                else if(dist[v] == dist[u]+wt)
                {
                    way[v] = (way[v] + way[u]) % MOD;
                }
            }
        }
        return way[n-1];
    }
}