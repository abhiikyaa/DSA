class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        HashSet <Integer> s1 = new HashSet<>();
        HashSet <Integer> s2 = new HashSet<>();

        for(int i = 0; i < n; i++)
        {
            int x = arr1[i];
            while(x != 0)
            {
                s1.add(x);
                x /= 10;
            }
        }

        for(int j = 0; j < m; j++)
        {
            int y = arr2[j];
            while(y != 0)
            {
                s2.add(y);
                y /= 10;
            }
        }

        int ans = 0;
        for(int s : s1)
        {
            if(s2.contains(s))
            {
                int len = String.valueOf(s).length();
                ans = Math.max(ans,len);
            }
        }
        return ans;


    }
}