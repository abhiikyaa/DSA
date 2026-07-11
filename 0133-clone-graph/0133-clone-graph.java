class Solution {
    class Pair {
        Node original;
        Node clone;

        Pair(Node original, Node clone) {
            this.original = original;
            this.clone = clone;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, Node> m = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        Node clone = new Node(node.val);
        m.put(node, clone);
        q.offer(new Pair(node, clone));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (Node nbr : curr.original.neighbors) {

                if (!m.containsKey(nbr)) {
                    Node newClone = new Node(nbr.val);
                    m.put(nbr, newClone);
                    q.offer(new Pair(nbr, newClone));
                }

                curr.clone.neighbors.add(m.get(nbr));
            }
        }

        return clone;
    }
}