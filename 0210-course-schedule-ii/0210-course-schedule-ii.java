class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        int[] inDeg = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            g.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int c = edge[0];
            int p = edge[1];
            g.get(p).add(c);
            inDeg[c]++;
        }
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }
        int[] order = new int[numCourses];
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            order[count] = node;
            count++;

            for(int nbr : g.get(node)){
                inDeg[nbr]--;
                if(inDeg[nbr] == 0){
                    q.add(nbr);
                }
            }

        }
        if( count == numCourses){
            return order;
        }
        else{
            return new int[0];
        }
    }
}