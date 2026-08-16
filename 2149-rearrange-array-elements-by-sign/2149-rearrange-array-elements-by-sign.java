class Solution {
    public int[] rearrangeArray(int[] nums) 
    {
        int m = nums.length;
        int i = 0;
        int j = 1;
        int[] arr = new int[m];
        for(int n : nums)
        {
            if(n > 0)
            {
                arr[i] = n;
                i += 2;
            }
            else
            {
                arr[j] = n;
                j += 2;
            }
        }
        return arr;

    }
}