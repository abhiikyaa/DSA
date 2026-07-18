class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int[] r : dist)
            Arrays.fill(r, (int) 1e8);
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != (int) 1e8 && dist[k][j] != (int) 1e8) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        int minc = n;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++)
                if (dist[i][j] <= distanceThreshold)
                    c++;
            if (c <= minc) {
                minc = c;
                ans = i;
            }
        }
        return ans;
    }
}