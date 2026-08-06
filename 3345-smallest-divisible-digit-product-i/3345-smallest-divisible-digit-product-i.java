class Solution {
    public int smallestNumber(int n, int t) 
    {
        for(int i = n; i <= 100; i++)
        {
            int x = i%10;
            int y = Math.max(((i/10)%10),1);
            if((x*y)%t == 0) return i;
        }
        return 100;
    }
}