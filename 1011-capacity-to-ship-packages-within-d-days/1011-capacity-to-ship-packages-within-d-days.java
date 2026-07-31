class Solution {
    public int shipWithinDays(int[] weights, int days) 
    {
        int n = weights.length;
        int l = 0;
        int r = 0;
        int ans = 0;
        for(int i = 0; i <n; i++)
        {
            l = Math.max(weights[i],l);
        }
        for(int i = 0; i < n; i++)
        {
            r += weights[i];
        }

        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(isValid(mid,weights,days))
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

    public boolean isValid(int mid, int[] arr, int days)
    {
        int n = arr.length;
        int twt = 0;
        int d = 1;
        for(int i = 0; i < n; i++)
        {
            if(twt + arr[i] <= mid)
            {
                twt += arr[i];
            }
            else
            {
                d++;
                twt = arr[i];
            }
        }
        return d <= days;
    }
}