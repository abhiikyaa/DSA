class Solution {
    public int minSpeedOnTime(int[] dist, double hour)
    {
        int l = 1;
        int r = 10000000;
        int ans = -1;

        while (l <= r) 
        {
            int mid = l + (r - l) / 2;
            if (isValid(mid, hour, dist)) 
            {
                ans = mid;
                r = mid - 1;
            } 
            else 
            {
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean isValid(int speed, double hour, int[] dist) 
    {
        int n = dist.length;
        double time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }
        time += (double) dist[dist.length - 1] / speed;
        if(time <= hour) return true;
        else return false;
    }
}