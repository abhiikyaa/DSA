class Solution {
    class Pair
    {
        int node;
        int wt;
        Pair(int node, int wt)
        {
            this.node = node;
            this.wt = wt;
        }
    }
    public int minCostConnectPoints(int[][] points) 
    {
        int n = points.length;
        boolean[] vis = new boolean[n];
        PriorityQueue <Pair> pq = new PriorityQueue<>((a,b)-> a.wt-b.wt);
        pq.add(new Pair(0,0));

        int sum = 0;
        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.wt;

            if(vis[node]) continue;
            vis[node] = true;
            sum += wt;

            for(int nbr = 0; nbr < n; nbr++)
            {
                if(!vis[nbr])
                {
                    int dist = Math.abs(points[node][0] - points[nbr][0]) + Math.abs(points[node][1] - points[nbr][1]);

                    pq.add(new Pair(nbr, dist));
                }
            }
        }
        return sum;
    }
}