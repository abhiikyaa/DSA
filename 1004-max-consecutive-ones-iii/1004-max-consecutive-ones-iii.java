class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int  l = 0;
        int maxlen = 0;
        for (int r = 0; r < nums.length; r++){
            if(nums[r] == 0){
                count++;
            }
            while(count > k){
                if(nums[l] == 0){
                    count--;
                }
                l++;
            }
            maxlen = Math.max(maxlen, r-l+1);
        }
        return maxlen;
        
        
    }
}