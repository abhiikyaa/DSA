class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        int[] visited = new int[v];
        int provinces = 0;

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                provinces++;
                bfs(isConnected, visited, i);
            }
        }
        return provinces;
    }

    private void bfs(int[][] isConnected, int[] visited, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
                if (isConnected[current][neighbor] == 1 && visited[neighbor] == 0) {
                    q.add(neighbor);
                    visited[neighbor] = 1;
                }
            }
        }
    }
}
