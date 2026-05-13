class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            while(num>0)
            {
                int dig = num%10;
                temp.add(dig);
                num = num/10;
            }
            for(int i=0; i<temp.size(); i++)
            {
                list.add(temp.get(temp.size()-i-1));
            }
        }

        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++)
        {
            ans[i] = list.get(i);
        }
        return ans;
    }
}