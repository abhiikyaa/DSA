class Solution {
    public boolean isIsomorphic(String s, String t) 
    {
        if(s.length() != t.length()) return false;
        HashMap<Character,Character> m1 = new HashMap<>();
        HashMap<Character,Character> m2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            char x = s.charAt(i);
            char y = t.charAt(i);

            if(m1.containsKey(x) && m1.get(x) != y)
            {
                return false;                
            }
            if(m2.containsKey(y) && m2.get(y) != x)
            {
                return false;                
            }
            m1.put(x,y);
            m2.put(y,x);
        }
        return true;

    }
}