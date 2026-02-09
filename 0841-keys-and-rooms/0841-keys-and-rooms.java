class Solution {
    public boolean bfs (List<List<Integer>> rooms, boolean[] visited){
        Queue < Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int nbr : rooms.get(node)){
                if(visited[nbr] == false){
                    visited[nbr] = true;
                    q.add(nbr);
                }
            }
        }
        for(boolean unlocked : visited){
            if(!unlocked){
                return false;
            }
        }    
        return true;

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        return bfs(rooms, visited);
        
    }
}