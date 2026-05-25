class Solution {
    public int passwordStrength(String password) 
    {
        int n = password.length();
        boolean[] vis = new boolean[128];
        int count = 0;
        for(char c : password.toCharArray())
        {
            if(vis[c]) continue;
            vis[c] = true;

            if(c >= 'a' && c <= 'z')
            {
                count += 1;
            }
            else if(c >= 'A' && c <= 'Z')
            {
                count += 2;
            }
            else if(c >= '0' && c <= '9')
            {
                count += 3;
            }
            else if(c == '!' || c == '@' || c == '#' || c == '$')
            {
                count += 5;
            }
        }
        return count;
    }
}