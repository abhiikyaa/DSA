class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i=n-1;i>0;i--)
        {
            if(nums[i] > nums[i-1])
            {
                idx = i;
                break;
            }
        }
        if(idx == -1)
        {
            reverse(nums,0,n-1);
            return;
        }
        int num = idx;
        for(int i=idx+1;i<n;i++)
        {
            if(nums[i] <= nums[num] && nums[idx-1] < nums[i])
                num = i;
        }
        int temp = nums[idx-1];
        nums[idx-1] = nums[num];
        nums[num] = temp;
        reverse(nums,idx,n-1);
    }
    public void reverse(int []nums,int left,int right)
    {
        while(left < right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}