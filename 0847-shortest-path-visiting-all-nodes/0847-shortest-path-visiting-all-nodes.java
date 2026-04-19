class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int t = (1<< n) - 1;
        boolean[][] vis = new boolean[n][t];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i< n; i++){
            q.offer(new int[]{i, 1<< i});
        }
        int count = 0;
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0; i < s; i++){
                int[] curr = q.poll();
                int node = curr[0];
                int state = curr[1];
                if (state == t) {
                    return count;
                }
                if (vis[node][state]) {
                    continue;
                }
                vis[node][state] = true;
                for (int next : graph[node]) {
                    q.offer(new int[]{next, state | (1 << next)});
                }

            }
            count++;
        }
        return -1;
    }
}
