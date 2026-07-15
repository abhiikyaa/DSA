class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        int[] inDeg = new int[n];
        for(int i = 0; i < n; i++)
        {
        for(int g : graph[i])
        {
            adj.get(g).add(i);
            inDeg[i]++;
        }
        }

        ArrayList <Integer> ans = new ArrayList<>();
        bfs(adj,n,inDeg,ans);
        Collections.sort(ans);
        return ans;
    }

    public void bfs(ArrayList<ArrayList<Integer>> adj, int n, int[] inDeg, ArrayList <Integer> ans)
    {
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            if(inDeg[i] == 0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(int nbr : adj.get(curr))
            {
                inDeg[nbr]--;
                if(inDeg[nbr] == 0)
                {
                    q.add(nbr);
                }
            }
            ans.add(curr);
        }
    }
}