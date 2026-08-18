class Solution {
    public int largestInteger(int[] nums, int k) 
    {
        int n = nums.length;
        int l = 0;
        int r = k - 1;

        HashMap<Integer, Integer> m = new HashMap<>();
        int max = Integer.MIN_VALUE;

        while(r < n)
        {
            for(int i = l; i <= r; i++)
            {
                boolean found = false;
                for(int j = l; j < i; j++)
                {
                    if(nums[j] == nums[i])
                    {
                        found = true;
                        break;
                    }
                }

                if(!found)
                {
                    m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
                }
            }

            l++;
            r++;
        }

        for(int num : m.keySet())
        {
            if(m.get(num) == 1)
            {
                max = Math.max(max, num);
            }
        }

        if(max == Integer.MIN_VALUE) return -1;
        else return max;
    }
}