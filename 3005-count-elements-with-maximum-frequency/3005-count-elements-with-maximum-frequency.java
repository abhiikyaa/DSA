class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int n : nums)
        {
            m.put(n,m.getOrDefault(n,0)+1);
        }

        int max = 0;
        for(int value : m.values())
        {
            max = Math.max(max,value);
        }
        
        int ans = 0;
        for(int value : m.values())
        {
            if(value == max)
            {
                ans += value;
            }
        }
        return ans;
        
    }
}