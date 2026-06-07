class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int ans1 = solve1(nums,0,dp1);
        int ans2 = solve2(nums,1,dp2);
        return Math.max(ans1,ans2);
    }
    public int solve1(int[] nums, int i, int[] dp1)
    {
        if(i > nums.length-2) return 0;
        if(dp1[i] != -1) return dp1[i];
        int take = nums[i] + solve1(nums,i+2,dp1);
        int skip = solve1(nums,i+1,dp1);
        return dp1[i] = Math.max(take,skip);
    }
    public int solve2(int[] nums, int i, int[] dp2)
    {
        if(i >= nums.length) return 0;
        if(dp2[i] != -1) return dp2[i];
        int take = nums[i] + solve2(nums,i+2,dp2);
        int skip = solve2(nums,i+1,dp2);
        return dp2[i] = Math.max(take,skip);
    }
}