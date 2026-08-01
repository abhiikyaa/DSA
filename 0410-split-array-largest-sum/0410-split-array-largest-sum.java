class Solution {
    public int splitArray(int[] nums, int k) {
        int s = 1;
        int e = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            e += nums[i];
        }

        while(s <= e){
            int m = s + (e-s)/2;
            if(isPossible(nums, k ,m)){
                ans = m;
                e = m - 1;
            }
            else{
                s = m + 1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[] nums, int k, int c){
        int d = 1;
        int l = 0;
        for(int n : nums){
            if(n > c) return false;
            if(l + n > c){
                d++;
                l = 0;
            }
            l += n;
        }
        return d <= k;
    }
}