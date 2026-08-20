class Solution {
    public int[] resultArray(int[] nums) 
    {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        if(n == 2) return nums;
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int j1 = 0;
        int j2 = 0;
        for(int i = 2; i < n; i++)
        {
            if(arr1[j1] > arr2[j2])
            {
                arr1[j1+1] = nums[i];
                j1++;
            }
            else
            {
                arr2[j2+1] = nums[i];
                j2++;
            }
        }    
        int[] ans = new int[j1+j2+2];
        int k = 0;
        for(int i = 0; i <= j1; i++)
        {
            ans[k++] = arr1[i];
        }
        for(int i = 0; i <= j2; i++)
        {
            ans[k++] = arr2[i];
        }
        return ans;

    }
}