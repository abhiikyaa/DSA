class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue <Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int n : stones){
            pq.add(n);
        }
        while(pq.size()>1){
            int y = pq.poll();
            int x = pq.poll();
            if(x!=y) pq.add(y-x);
        }
        if(pq.size() == 0) return 0;
        return pq.poll();

    }
}