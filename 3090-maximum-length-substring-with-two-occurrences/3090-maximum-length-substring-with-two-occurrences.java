class Solution {
    public int maximumLengthSubstring(String s) 
    {
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        int l = 0;
        int ans = 0;

        for(int r = 0; r < s.length(); r++)
        {
            freq[arr[r] - 'a']++;
            while(freq[arr[r]-'a'] > 2)
            {
                freq[arr[l]-'a']--;
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}