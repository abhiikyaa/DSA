class Solution {
    public int maxPalindromes(String s, int k) 
    {
        int n = s.length();
        if(k == 1) return n;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(s,k,0,dp);
    }
    public boolean palindrom(String s, int l, int r)
    {
        while(l < r)
        {
            if(s.charAt(l) != s.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public int solve(String s, int k, int i, int[] dp)
    {
        if(i >= s.length()) return 0;
        if(dp[i] != -1) return dp[i];
        int pick = 0;
        int notPick = solve(s,k,i+1,dp);
        for(int j = i+k-1 ; j < s.length(); j++)
        {
            if(palindrom(s,i,j))
            {
                //pick = 1 + solve(s,k,j+1,dp);
                int curr = 1 + solve(s,k,j+1,dp);
                if(curr > pick)
                {
                    pick = curr;
                }
            }
        }
        return dp[i] = Math.max(pick,notPick);
    }
}