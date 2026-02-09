class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            result.add(new ArrayList<>());
        }
        for(int []edge : edges){
            result.get(edge[0]).add(edge[1]);
            result.get(edge[1]).add(edge[0]);
        }
        return bfs(source , destination, result);
    }
    public boolean bfs(int src, int dest, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        visited[src] = true;
        Queue < Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()){
            int node = q.poll();
            if(node == dest){
                return true;
            }
            for(int nbr : adj.get(node)){
                if(visited[nbr] == false){
                    visited[nbr] = true;
                    q.add(nbr);
                }
            }
        }
        return false;
    }
}