class Solution {
    class DSU{
        int[] parent;
        DSU(int n){
            parent = new int[n];
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
            parent[pb] = pa;
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU ans = new DSU(n+1);

        for(int[] e : edges){
            if(!ans.union(e[0],e[1])){
                return e;
            }
        }
        return new int[0];
    }
}