class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int i = 0;
        for(int j = 0; j < n; j++)
        {
            if(nums[i] != nums[j])
            {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
}