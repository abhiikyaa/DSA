class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        int l = 0;
        int r;
        int n = nums.length;
        for(int i = 0 ; i < n; i++){
            total += nums[i]; 
        }
        for(int i = 0; i < n; i++){
            r = total - l - nums[i];
            if(l == r){
                return i;
            }
            l += nums[i];
        }
        return -1;

    }
}