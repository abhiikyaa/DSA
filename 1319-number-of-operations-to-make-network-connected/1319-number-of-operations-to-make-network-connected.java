class Solution {
    class DSU
    {
        int[] parent;
        int[] rank;
        DSU(int n)
        {
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++)
            {
                parent[i] = i;
                rank[i] = i;
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
            if(rank[pa] < rank[pb]) parent[pa] = pb;
            else if(rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) 
    {
        int m = connections.length;
        if(m < n-1) return -1;
        DSU dsu = new DSU(n);
        int c = 0;

        for (int[] e : connections)
        {
            int u = e[0];
            int v = e[1];
            dsu.union(u,v);
        }

        for(int i = 0; i < n; i++)
        {
            if(dsu.find(i) == i)
            {
                c++;
            }
        }

        return c-1;   
    }
}