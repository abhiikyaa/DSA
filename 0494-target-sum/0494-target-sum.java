class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sumOfNums = 0;

        for(int i: nums) sumOfNums += i;
    
        if((target + sumOfNums) % 2 != 0) return 0;
        int P = (target + sumOfNums)/2;
        if(P < 0) return 0;
        return countOfSubsetSum(nums, n, P);
    }
    public int countOfSubsetSum(int[] arr, int n, int sum){
       int[][] dp = new int[n + 1][sum +1];
      
       for(int j=0;j<=sum;j++) dp[0][j]=0;
       for(int i=0;i<=n;i++) dp[i][0] = 1;

       for(int i=1;i<=n;i++){
         for(int j=0;j<=sum;j++){ 
            if(arr[i-1] <= j){
                dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];
            }
            else dp[i][j] = dp[i-1][j];
         }
       }
       return dp[n][sum];
    }
   
}