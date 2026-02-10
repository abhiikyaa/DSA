class Solution {
    public void dfs (int node,List<List<Integer>> rooms, boolean[] visited){
        visited[node] = true;
        for(int nbr : rooms.get(node)){
            if(!visited[nbr]){
                dfs(nbr, rooms, visited);

            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        int n = rooms.size();
        dfs(0,rooms,visited);

        for(int i = 0;i < n;i++){
            if(visited[i] == false){
                return false;
            }
        }
        return true;
        
    }
}