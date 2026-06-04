class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) 
        {
            q.add(i);
        } 
        for (int d : deck) 
        {                  
            int pos = q.poll();
            res[pos] = d;
            if (!q.isEmpty()) 
            {
                q.add(q.poll());
            }                       
        }

        return res;
    }
}