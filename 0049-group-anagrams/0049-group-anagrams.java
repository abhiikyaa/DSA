class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        int n = strs.length;
        HashMap<String, ArrayList<String>> m = new HashMap<>();
        for(String s : strs)
        {
            int[] freq = new int[26];
            for(char ch : s.toCharArray())
            {
                freq[ch - 'a']++;
            }
            String key = Arrays.toString(freq);
            if(!m.containsKey(key))
            {
                m.put(key, new ArrayList<>());
            }
            m.get(key).add(s);
        }
        return new ArrayList<>(m.values());

    }
}
