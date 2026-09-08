class Solution {
    public String reverseVowels(String s) 
    {
        char[] ch = s.toCharArray();
        char[] v = new char[ch.length];
        int j = 0;

        for(int i = 0; i < ch.length; i++)
        {
            if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' ||
               ch[i] == 'o' || ch[i] == 'u' ||
               ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' ||
               ch[i] == 'O' || ch[i] == 'U')
            {
                v[j] = ch[i];
                j++;
            }
        }

        int l = 0;
        int r = j - 1;

        while(l < r)
        {
            char temp = v[l];
            v[l] = v[r];
            v[r] = temp;

            l++;
            r--;
        }

        int k = 0;
        for(int i = 0; i < ch.length; i++)
        {
            if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' ||
               ch[i] == 'o' || ch[i] == 'u' ||
               ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' ||
               ch[i] == 'O' || ch[i] == 'U')
            {
                ch[i] = v[k];
                k++;
            }
        }

        return new String(ch);
    }
}