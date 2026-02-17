class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int n = digits.length();
        if(n==0) return ans;
        helper(ans,"",n,digits,0);
        return ans;
        
    }
    void helper(List<String> ans,String sb,int n,String digit,int idx){
        if(idx==n){
            ans.add(sb);
            return;
        }
        char curr = digit.charAt(idx);
        String s = Atchar(curr);
        for(int i=0;i<s.length();i++){
            helper(ans,sb+s.charAt(i),n,digit,idx+1);

        }
        

    }
    String Atchar(char curr){
        switch(curr){
            case '2':
            return "abc";
            case '3':
            return "def";
            case '4':
            return "ghi";
            case '5':
            return "jkl";
            case '6':
            return "mno";
            case '7':
            return "pqrs";
            case '8': 
            return "tuv";
            case '9':
            return "wxyz";
        }
        return "";
    }

    
    
}