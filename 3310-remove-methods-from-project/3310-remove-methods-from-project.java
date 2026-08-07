class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] i : invocations)
        {
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        vis[k] = true;
        while(!q.isEmpty())
        {  
            int curr = q.poll();
            for(int nbr : adj.get(curr))
            {
                if(!vis[nbr])
                {
                    vis[nbr] = true;
                    q.add(nbr);
                }
            }
        }

        for(int[] i : invocations)
        {
            int u = i[0];
            int v = i[1];
            if(!vis[u] && vis[v])
            {
                List<Integer> lst = new ArrayList<>();
                for(int j = 0; j < n; j++)
                {
                    lst.add(j);
                }
                return lst;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            if(!vis[i])
            {
                ans.add(i);
            }
        }
        return ans;
    }
}