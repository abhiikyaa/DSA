class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int max = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            char curr  = s.charAt(r);
            if (curr=='a' || curr=='e' ||curr=='i' ||  curr=='o' || curr=='u'){
                count++;
            }
            if(r-l+1 > k){
                char exc = s.charAt(l);
                if(exc == 'a' || exc == 'e' || exc == 'i' || exc == 'o' || exc == 'u'){
                    count--;
                }
                l++;
            }
            max = Math.max(max,count);


        }
        return max ;
        
    }
}