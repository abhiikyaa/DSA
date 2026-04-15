class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length/2;
        HashMap<Integer,Integer> m = new HashMap<>();

        for(int w : nums){
            m.put(w,m.getOrDefault(w,0)+1);
        }
        for(int w : nums){
            if(m.get(w) > n){
                return w;
            }
        }
        return -1;
    }
}