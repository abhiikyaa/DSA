class Solution {
    class Pair{
        int node;
        int cost;
        int time;
        Pair(int node, int cost, int time){
            this.node = node;
            this.cost = cost;
            this.time = time;
        }
    }
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i =0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int t = e[2];
            adj.get(u).add(new int[]{v,t});
            adj.get(v).add(new int[]{u,t});
        }
        
        int[][] ans = new int[n][maxTime+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(ans[i],Integer.MAX_VALUE);
        }

        PriorityQueue <Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        ans[0][0] = passingFees[0];
        pq.add(new Pair(0,passingFees[0],0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int cost = curr.cost;
            int time = curr.time;

            if(node == n-1){
                return cost;
            }

            for(int[] nbr : adj.get(node)){
                int nn = nbr[0];
                int nt = nbr[1];

                int newTime = time + nt;
                if(newTime > maxTime){
                    continue;
                }

                int newCost = cost + passingFees[nn];

                if(newCost < ans[nn][newTime]){
                    ans[nn][newTime] = newCost;
                    pq.add(new Pair(nn, newCost, newTime));
                }
            }
        }
        return -1;
    }
}