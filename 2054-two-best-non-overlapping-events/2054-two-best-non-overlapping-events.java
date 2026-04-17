class Solution {
    public int maxTwoEvents(int[][] events) {
        //sort based on end time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        //sort based on start time
        Arrays.sort(events,(a,b)-> a[0]-b[0]);
        int preMax = 0;
        int ans = 0;
        for(int[] event : events){
            //find preMax
            while(!pq.isEmpty() && pq.peek()[1] < event[0]){
                preMax = Math.max(preMax, pq.peek()[2]);
                pq.poll();
            }
            ans = Math.max(ans, preMax + event[2]);
            pq.offer(event);
        }
        return ans;
    }
}
