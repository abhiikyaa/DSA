class Solution {
    public int maxSubarrayLength(int[] nums, int k) 
    {
        int n = nums.length;
        int l = 0;
        int count = 0;
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int r = 0; r < n; r++)
        {
            m.put(nums[r],m.getOrDefault(nums[r],0)+1);
            while(m.get(nums[r]) > k) 
            {
                m.put(nums[l],m.get(nums[l])-1);
                l++;
            }
            count = Math.max(count,r-l+1);
        }
        return count;

    }
}