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
        boolean[] visited = new boolean[n];
        return dfs(source , destination, result, visited);
    }
    public boolean dfs(int node, int dest, ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        if(node == dest){
            return true;
        }
        visited[node] = true;
        for(int nbr : adj.get(node)){
            if(visited[nbr] == false){
                if(dfs(nbr, dest, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}