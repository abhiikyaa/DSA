class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        int n = piles.length;
        int l = 1;
        int r = 0;
        int ans = 0;
        
        for(int i = 0; i < n; i++)
        {
            r = Math.max(r,piles[i]);
        }

        while(l<=r)
        {
            int mid = l+(r-l)/2;
            if(isValid(mid,h,piles))
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
    public boolean isValid(int mid, int h, int[] arr)
    {
        int n = arr.length;
        int t = 0;
        for(int i = 0; i < n; i++)
        {
            t += Math.ceil((double)arr[i]/mid);
        }
        if(t <= h) return true;
        else return false;
    }
}