class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int i = 0;
        int j = 1;
        int n = intervals.length;
        while(j<n){
            if(intervals[j][0] > intervals[i] [1]){
                intervals[++i] = intervals[j++];
            }
            else{
                intervals[i][1] = Math.max(intervals[i] [1], intervals[j++] [1]);
            }
        }
        int [] [] ans = new int [i+1] [2];
        for(j=0; j<=i;j++) ans[j] = intervals[j];
        return ans;
    }
}