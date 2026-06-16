class Solution {
    public int subarraySum(int[] nums, int k) {
        int s = 0;
        int c = 0;
        HashMap<Integer,Integer> m = new HashMap<>();
        m.put(0,1);
        for(int num : nums)
        {
            s += num;
            c += m.getOrDefault(s-k,0);
            m.put(s,m.getOrDefault(s,0)+1);
        }
        return c;
    }
}