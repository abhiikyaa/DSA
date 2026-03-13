class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s = 1;
        int e = 0;
        int ans = 0;
        for(int i = 0; i < weights.length; i++){
            e += weights[i];
        }

        while(s <= e){
            int m = s + (e-s)/2;

            if(isPossible(weights, days, m)){
                ans = m;
                e = m -1;
            }
            else{
                s = m + 1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[] weights, int days, int c){
        int d = 1;
        int l = 0;
        for(int w : weights){
            if(w > c) return false;
            if(l + w > c){
                d++;
                l = 0;
            }
            l += w;
        }
        return d <= days;
    }
}