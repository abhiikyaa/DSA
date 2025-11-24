class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(nums, 0, ans, res);
        return res;
    }
    public void solve(int nums[], int start, List<Integer>ans, List<List<Integer>> res) {
        if(nums.length == start) {
            res.add(new ArrayList<>(ans));
            return;
        }
        solve(nums,start + 1, ans, res);
        ans.add(nums[start]);
        solve(nums, start + 1, ans, res);
        ans.remove(ans.size() - 1);

    }
}