class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            adj.get(u).add(v);
            inDeg[v]++;
        }
        
        return bfs(adj,numCourses,inDeg);
    }
    public boolean bfs(ArrayList<ArrayList<Integer>> adj,int numCourses, int[] inDeg)
    {
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
        {
            if(inDeg[i] == 0) q.add(i);
        }
        int cnt = 0;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            cnt++;
            for(int nbr : adj.get(curr))
            {
                inDeg[nbr]--;
                if(inDeg[nbr] == 0) q.add(nbr);
            }
        }
        if(cnt == numCourses) return true;
        else return false;
    }
}