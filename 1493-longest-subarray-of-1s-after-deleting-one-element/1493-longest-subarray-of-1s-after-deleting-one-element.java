class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int c = 0;
        while(j < n)
        {
            if(nums[j] == 0)
            {
                c++;
            }
            while(c >= 2)
            {
                if(nums[i] == 0)
                {
                    c--;
                }
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);
            j++;

        }
        return maxLen-1;
    }
}