class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        int n = strs.length;
        Arrays.sort(strs);
        String s = "";
        int i = 0;
        int j = n;
        while(i < strs[0].length())
        {
            if(strs[0].charAt(i) == strs[j-1].charAt(i))
            {
                s += strs[0].charAt(i);
            }
            else break;
            i++;
        }
        return s;
    }
}