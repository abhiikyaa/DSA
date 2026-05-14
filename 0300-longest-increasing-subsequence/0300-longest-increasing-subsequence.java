class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList <Integer> ls = new ArrayList<>();
        ls.add(nums[0]);
        for(int i = 1; i < n; i++)
        {
            if(ls.get(ls.size()-1) < nums[i])
            {
                ls.add(nums[i]);
            }
            else
            {
                int l = 0;
                int h = ls.size() - 1;
                while(l<=h)
                {
                    int mid = (h+l)/2;
                    if(ls.get(mid) >= nums[i])
                    {
                        h = mid -1;
                    }
                    else
                    {
                        l = mid + 1;
                    }
                }
                ls.set(l,nums[i]);
            }

        } 
        return ls.size();
    }
}