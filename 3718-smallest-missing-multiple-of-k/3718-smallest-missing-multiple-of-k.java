class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) 
        {
            seen.add(n);
        }

        int ans = k;
        while (seen.contains(ans)) {
            ans += k;
        }

        return ans;
    }
}