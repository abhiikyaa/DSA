class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
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
        void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if(pa == pb) return;
            if(rank[pa] > rank[pb]){
                parent[pb] = pa;
            }
            else if(rank[pb] > rank[pa]){
                parent[pa] = pb;
            }
            else{
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a,b)-> a[2]-b[2]);

        Integer[] q = new Integer[queries.length];
        for(int i = 0; i < queries.length; i++){
            q[i] = i;
        }
        Arrays.sort(q, (a,b)-> queries[a][2] - queries[b][2]);
        DSU obj = new DSU(n);
        boolean[] ans = new boolean[queries.length];
        int j = 0;
        for (int i : q){
            int u = queries[i][0];
            int v = queries[i][1];
            int l = queries[i][2];
            while(j < edgeList.length && edgeList[j][2] < l){
            obj.union(edgeList[j][0],edgeList[j][1]);
            j++;
            }
            if(ans[i] = obj.find(u) == obj.find(v)){
                ans[i] = true;
            }
        }
        return ans;
        
    }

}