class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            g.add(new ArrayList<>());
        }

        int[] indeg = new int[numCourses];
        for(int[] p : prerequisites){
            g.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }
        Queue <Integer> q = new LinkedList<>();
        for(int i =0; i < numCourses; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int nbr : g.get(node)){
                indeg[nbr]--;
                if(indeg[nbr] == 0){
                    q.add(nbr);
                }
            }

        }
        return count == numCourses;
    }
}