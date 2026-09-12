class Solution {
    public int romanToInt(String s) 
    {
        char[] ch = s.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;

        for(int i = 0; i < ch.length; i++)
        {
            if(i < ch.length - 1 && map.get(ch[i]) < map.get(ch[i + 1]))
            {
                ans -= map.get(ch[i]);
            }
            else
            {
                ans += map.get(ch[i]);
            }
        }

        return ans;
    }
}