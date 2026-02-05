class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set <Integer> s = new HashSet<>();
        int l = 0;
        int r = 0;
        int sum = 0;
        int max = 0;
        while(r < nums.length){
            if(!s.contains(nums[r])){
                sum += nums[r];
                s.add(nums[r]);
                max = Math.max(sum , max);
                r++;
            }
            else{
                sum -= nums[l];
                s.remove(nums[l]);
                l++;
            }

        }
        return max;
        
    }
}