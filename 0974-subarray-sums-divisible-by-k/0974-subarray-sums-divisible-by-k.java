class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        freq.put(0 , 1);
        int count = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int remainder = sum%k;
            if(remainder < 0){
                remainder += k;
            }
            int result = freq.getOrDefault(remainder, 0);
            count += result;

            freq.put(remainder, freq.getOrDefault(remainder, 0)+1);
        }
        return count;
    }
}