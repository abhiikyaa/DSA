class Solution {
    public int smallestDivisor(int[] nums, int threshold) 
    {
        int n = nums.length;
        int l = 1;
        int r = 0;
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            r = Math.max(r,nums[i]);
        }   

        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(isValid(mid,threshold,nums))
            {
                ans = mid;
                r = mid-1;
            }
            else
            {
                l = mid+1;
            }
        }
        return ans;
    }
    public boolean isValid(int mid, int t, int[] arr)
    {
        int n = arr.length;
        int d = 0;
        for(int i = 0; i < n; i++)
        {
            d += Math.ceil((double)arr[i]/mid);
        }
        if(d <= t) return true;
        else return false;
    }
}