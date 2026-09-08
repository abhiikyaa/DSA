class Solution {
    public String mergeAlternately(String word1, String word2) 
    {
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i < ch1.length && j < ch2.length)
        {
            sb.append(ch1[i]);
            sb.append(ch2[j]);
            i++;
            j++;
        }

        while(i < ch1.length)
        {
            sb.append(ch1[i]);
            i++;
        }

        while(j < ch2.length)
        {
            sb.append(ch2[j]);
            j++;
        }
        
        return sb.toString();
    }
}