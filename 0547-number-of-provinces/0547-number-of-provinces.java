class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        int[] visited = new int[v];
        int provinces = 0;

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                provinces++;
                dfs(isConnected, visited, i);
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, int[] visited, int node) {
        visited[node] = 1;
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
                if (isConnected[node][neighbor] == 1 && visited[neighbor] == 0) {
                    dfs(isConnected, visited, neighbor);
                }
            }
    }
}
