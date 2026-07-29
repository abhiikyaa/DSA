class Solution {
    public int minDays(int[] bloomDay, int m, int k) 
    {
        int n = bloomDay.length;
        if((long)m*k > n) return -1;
        int l = 1;
        int r = 0;
        for(int i = 0; i < n; i++)
        {
            r = Math.max(r,bloomDay[i]);
        }

        while(l <= r)
        {
            int mid = l+(r-l)/2;
            if(isValid(mid,bloomDay,m,k))
            {
                r = mid-1;
            }
            else
            {
                l = mid+1;
            }
        }
        return l;
    }

    public boolean isValid(int mid, int[] arr, int m, int k)
    {
        int n = arr.length;
        int f = 0;
        int b = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] <= mid)
            {
                f++;
            }
            else
            {
                f = 0;
            }
            if(f == k)
            {
                b++;
                f=0;
            }
            if(b >= m) return true;
        }
        return false;
    }
}