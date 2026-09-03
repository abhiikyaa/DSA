class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int prefix[] = new int[n];
        prefix[0] = stones[0];
        for(int i=1;i<n;i++){
            prefix[i] = stones[i] + prefix[i-1];

        }
        int dp[]= new int[n+1];
        dp[n-1] = prefix[n-1];
        for(int i=n-2;i>=1;i--){
            int take = prefix[i]-dp[i+1];
            int ntake = dp[i+1];
            dp[i] = Math.max(take,ntake);
        }
        return dp[1];
        
    }
}