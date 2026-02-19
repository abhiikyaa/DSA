class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int[] ans = new int [n];
        int idx = 0;
        int count = 1;

        for(int  i = 1; i < n; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }
            else{
                ans[idx++] = count;
                count = 1;
            }
        }
        ans[idx++] =  count;
        int sol = 0;
        for(int  i = 0; i < idx - 1; i++){
            sol += Math.min(ans[i], ans[i+1]);
        }
        return sol;
    }
}