class Solution {
    class DSU
    {
        int[] parent;
        DSU(int n)
        {
            parent = new int[n];
            for(int i = 0; i < n; i++)
            {
                parent[i] = i;
            }
        }
        int find(int x)
        {
            if(parent[x] != x)
            {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b)
        {
            int pa = find(a);
            int pb = find(b);
            if(pa == pb) return;
            parent[pb] = pa;
        }
    }
    public int[] findRedundantConnection(int[][] edges) 
    {
        int n = edges.length;
        DSU dsu = new DSU(n+1);

        for(int[] e : edges)
        {
            int u = e[0];
            int v = e[1];
            if(dsu.find(u) == dsu.find(v)) return e;
            dsu.union(u,v);
        }
        return new int[0];  
    }
}