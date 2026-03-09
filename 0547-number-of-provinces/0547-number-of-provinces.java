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
        void union(int a , int b){
            int pa = find(a);
            int pb = find(b);
            if(pa == pb) return;
            parent[pb] = pa; 
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        DSU ans = new DSU(n);

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(isConnected[i][j] == 1){
                    ans.union(i,j);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(ans.find(i) == i){
                count++;
            }
        }
        return count;
    }    
}
