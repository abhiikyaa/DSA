class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp1 = new int[nums.length + 1];
        Arrays.fill(dp1 , -1);

        int[] dp2 = new int[nums.length + 1];
        Arrays.fill(dp2 , -1);

        return Math.max(MaxAmt1(nums , nums.length-2, dp1) , MaxAmt2(nums , nums.length-1 , dp2));
    }
    public int MaxAmt1(int[] nums, int n, int[] dp1){
        if(n < 0) return 0;

        if(n == 0) return nums[0];

        if(n == 1) return Math.max(nums[0] , nums[1]);

        if(dp1[n] != -1) return dp1[n];

        dp1[n] = Math.max(nums[n] + MaxAmt1(nums, n-2, dp1) , MaxAmt1(nums , n-1 , dp1));

        return dp1[n];
    }

    public int MaxAmt2(int[] nums , int n , int[] dp2){
        if(n < 1) return 0;

        if(n == 1) return nums[1];

        if(n == 2) return Math.max(nums[1] , nums[2]);

        if(dp2[n] != -1) return dp2[n];

        dp2[n] = Math.max(nums[n] + MaxAmt2(nums , n-2 , dp2) , MaxAmt2(nums , n -1, dp2));

        return dp2[n];
    }
}