class Solution {
    class Pair{
        int node;
        int money;
       
        Pair(int node,int money){
            this.node = node;
            this.money = money;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        if(src==dst) return 0;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int m = flights[i][2];

            adj.get(u).add(new Pair(v,m));
        }
         int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src,0));
        int dist = 0;
        int max = Integer.MAX_VALUE;
        while(!q.isEmpty()  && dist <= k+1){

            int size = q.size();
            
            while(size!=0){
                size--;

            Pair curr = q.poll();
            
            if(dist>k+1) continue;
            if(curr.node==dst){
               max= Math.min(max,curr.money);
            }

            for(Pair nbr : adj.get(curr.node)){
                
                int newM = nbr.money + curr.money;
                if(minCost[nbr.node]> newM){
                   minCost[nbr.node]= newM;
                   q.offer(new Pair(nbr.node,newM)); 
                }  
            }
            
            }
            dist++;
        }
        if(max==Integer.MAX_VALUE) return -1;
        return max;
    }
}