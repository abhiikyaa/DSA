class Solution {
    class Pair {
        int node;
        List<Integer> path;
        Pair(int node, List<Integer> path) 
        {
            this.node = node;
            this.path = path;
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {

        List<List<Integer>> ans = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();

        List<Integer> startPath = new ArrayList<>();
        startPath.add(0);

        q.offer(new Pair(0, startPath));

        int target = graph.length - 1;

        while (!q.isEmpty()) 
        {

            Pair curr = q.poll();

            int node = curr.node;
            List<Integer> path = curr.path;

            if (node == target) 
            {
                ans.add(path);
                continue;
            }

            for (int next : graph[node]) 
            {

                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(next);

                q.offer(new Pair(next, newPath));
            }
        }

        return ans;
    }
}