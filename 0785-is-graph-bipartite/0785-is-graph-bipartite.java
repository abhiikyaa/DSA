class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        char[] color = new char[n];
        Arrays.fill(color, 'G');

        for(int i = 0; i < n; i++){
            if(color[i] == 'G'){
                Queue <Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 'R';

                while(!q.isEmpty()){
                    int node = q.poll();

                    for(int nbr : graph[node]){

                        if(color[nbr] == 'G'){
                            if(color[node] == 'R'){
                                
                                color[nbr] = 'B';
                            }
                            else{
                                color[nbr] = 'R';
                            }
                            q.add(nbr);
                        }
                        else if(color[nbr] == color[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
        
    }
}