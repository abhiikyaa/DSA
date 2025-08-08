public class subsequence {
    public boolean isSubsequence(String s, String t) {
       int i=0;
       int j=0;
       while(i<s.length()&&j<t.length()){
        if(s.charAt(i)==t.charAt(j)){
            i++;
        }
        j++;
       }
       return i==s.length();
    }
    public static void main(String[] args) {
        subsequence obj = new subsequence();

        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println(s1 + " is subsequence of " + t1 + " ? " + obj.isSubsequence(s1, t1));
    }
    
}
