class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int m = times.length;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : times){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new Pair(v,w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.dist, b.dist));
        int[] ans = new int [n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;

        pq.offer(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int d = curr.dist;
            int u = curr.node;

            if(d > ans[u]) continue;

            for(Pair nbr : adj.get(u)){
                int nn = nbr.node;
                int nd = d + nbr.dist;

                if(ans[nn] > nd){
                    ans[nn] = nd;
                    pq.offer(new Pair(nn , nd));
                }
            }
        }
        int time = -1;
        for(int  i = 1; i <= n; i++){
            if(ans[i] == Integer.MAX_VALUE){
                return -1;
            }
            time = Math.max(time, ans[i]);
        }
        return time;
    }
}