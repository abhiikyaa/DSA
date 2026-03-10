class Solution {
    int[] parent;
    int[] size;
    public void init(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(size[parentA]>=size[parentB]){
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
        }else{
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
        }
    }
    public boolean equationsPossible(String[] equations) {
        init(26); 

        
        for(String eq : equations){
            int u = eq.charAt(0)-'a'; 
            int v = eq.charAt(3)-'a'; 

            if(eq.charAt(1)=='='){
                union(u, v); 
            }
        }

        for(String eq : equations){
            int u = eq.charAt(0)-'a';
            int v = eq.charAt(3)-'a';

            if(eq.charAt(1)=='!'){
                int parentU = find(u);
                int parentV = find(v);
                if(parentU==parentV) return false;
            }
        }
        return true; 
    }
}