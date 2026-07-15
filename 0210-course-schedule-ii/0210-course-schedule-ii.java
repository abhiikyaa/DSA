class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        int[] inDeg = new int[numCourses];
        for(int[] e : prerequisites)
        {
            int u = e[0];
            int v = e[1];
            adj.get(v).add(u);
            inDeg[u]++;
        }
        
        return bfs(adj,numCourses,inDeg);
    }
    public int[] bfs(ArrayList<ArrayList<Integer>> adj,int numCourses, int[] inDeg)
    {
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
        {
            if(inDeg[i] == 0) q.add(i);
        }
        int[] ans = new int[numCourses];
        int cnt = 0;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            ans[cnt] = curr;
            cnt++;
            for(int nbr : adj.get(curr))
            {
                inDeg[nbr]--;
                if(inDeg[nbr] == 0) q.add(nbr);
            }
        }
        if(cnt == numCourses) return ans;
        else return new int[0];
    }
}