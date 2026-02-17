class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n =graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        int[] inDeg = new int[n];
        for(int i = 0; i < n; i++){
            for(int edge : graph[i]){
                adj.get(edge).add(i);
                inDeg[i]++;
            }
        }

        Queue<Integer> q =new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i =0; i < n; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int nbr : adj.get(node)){
                inDeg[nbr]--;
                if(inDeg[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}