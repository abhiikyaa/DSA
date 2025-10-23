class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(); 
        int ans =0,srt =0,end = 0;
        if(n==1) return s;
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j)){
                    if(ans<(j-i)){
                        ans = j-i;
                        srt = i;
                        end = j;
                    }
                }
            }
        }  
        return s.substring(srt,end+1);
    }
    public static boolean isPalindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}