class Solution {
    public int maxTwoEvents(int[][] events) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        Arrays.sort(events,(a,b)-> a[0]-b[0]);
        int preMax = 0;
        int ans = 0;
        for(int[] e : events){
            while(!pq.isEmpty() && pq.peek()[1] < e[0]){
                preMax = Math.max(preMax, pq.peek()[2]);
                pq.poll();
            }
            ans = Math.max(ans,preMax + e[2]);
            pq.offer(e);
        }
        return ans;
    }
}