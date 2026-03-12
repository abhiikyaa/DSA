class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        int node ;
        DSU(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            node = n;
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        boolean union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if(pa == pb) return false;
            if(rank[pa] > rank[pb]){
                parent[pb] = pa;
            }
            if(rank[pb] > rank[pa]){
                parent[pa] = pb;
            }
            else{
                parent[pb] = pa;
                rank[pa]++;
            }
            node--;
            return true;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU a = new DSU(n);
        DSU b = new DSU(n);
        int count= 0;
        for(int[] e : edges){
            if(e[0] == 3){
                boolean ua = a.union(e[1],e[2]);
                boolean ub = b.union(e[1],e[2]);
                if(!ua && !ub){
                    count++;
                }
            }
        }
        for(int[] e : edges){
            if(e[0] == 1){
                if(!a.union(e[1],e[2])){
                    count++;
                }
            }
            else if(e[0]==2){
                if(!b.union(e[1],e[2])){
                    count++;
                }
            }
        }
        if(a.node != 1 || b.node != 1){
            return -1;
        }
        return count;
        
    }
}