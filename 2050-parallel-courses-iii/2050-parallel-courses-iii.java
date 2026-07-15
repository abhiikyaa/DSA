class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        int[] inDeg = new int[n];
        for(int[] e : relations)
        {
            int u = e[0]-1;
            int v = e[1]-1;
            adj.get(u).add(v);
            inDeg[v]++;
        }
        
        return bfs(adj,n,inDeg,time);
    }
    public int bfs(ArrayList<ArrayList<Integer>> adj,int n, int[] inDeg, int[] time)
    {
        Queue <Integer> q = new LinkedList<>();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++)
        {
            ans[i] = time[i];
            if(inDeg[i] == 0) q.add(i);
        }
        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(int nbr : adj.get(curr))
            {
                ans[nbr] = Math.max(ans[nbr] , ans[curr] + time[nbr]);
                inDeg[nbr]--;
                if(inDeg[nbr] == 0) q.add(nbr);
            }
        }

        int t = 0;
        for(int a : ans)
        {
            t = Math.max(a,t);
        }

        return t;
    }
}