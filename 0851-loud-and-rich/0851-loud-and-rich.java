class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int n = quiet.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indeg = new int[n];

        for (int[] edge : richer) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            indeg[v]++;
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int nbr : adj.get(node)) {

                if (quiet[ans[node]] < quiet[ans[nbr]]) {
                    ans[nbr] = ans[node];
                }

                indeg[nbr]--;

                if (indeg[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        return ans;
    }
}