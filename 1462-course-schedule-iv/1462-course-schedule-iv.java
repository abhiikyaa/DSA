class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indeg = new int[numCourses];
        
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indeg[v]++;
        }

 
        boolean[][] reachable = new boolean[numCourses][numCourses];

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(int nbr : adj.get(node)){
                
          
                reachable[node][nbr] = true;

                for(int i = 0; i < numCourses; i++){
                    if(reachable[i][node]){
                        reachable[i][nbr] = true;
                    }
                }

                indeg[nbr]--;
                if(indeg[nbr] == 0){
                    q.add(nbr);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for(int[] query : queries){
            ans.add(reachable[query[0]][query[1]]);
        }

        return ans;
    }
}