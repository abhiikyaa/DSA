class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int sum = 0;
        int maxsum = 0;
        while(r < nums.length){
            if(!set.contains(nums[r])){
                sum += nums[r];
                set.add(nums[r]);
                maxsum = Math.max(sum, maxsum);
                r++;
            
            }
            else{
                sum -= nums[l];
                set.remove(nums[l]);
                l++;
            }
        }
        return maxsum;
        
        
    }
}