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
            else if(rank[pa] < rank[pb]){
                parent[pa] = pb;
            }
            else{
                if(rank[pa] == rank[pb]){
                    parent[pb] = pa;
                    rank[pa]++;
                }
            }

        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU ans = new DSU(n);
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    ans.union(i, j);
                }
            }
        }

        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < n; i++){
            s.add(ans.find(i));
        }
        return n - s.size();
    }
}