class Solution {
    public int totalFruit(int[] fruits) {
        HashMap <Integer , Integer > m = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while(r<fruits.length){
            m.put(fruits[r], m.getOrDefault(fruits[r],0) + 1);

            while(m.size() > 2){
                m.put(fruits[l] , m.get(fruits[l]) - 1);
            
                if(m.get(fruits[l]) == 0){
                    
                    m.remove(fruits[l]);
                }            
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}