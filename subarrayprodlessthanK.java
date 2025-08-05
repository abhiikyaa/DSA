public class subarrayprodlessthanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int s = 0;
        int p = 1;
        int count = 0;
        for (int e = 0; e < nums.length; e++) {
            p *= nums[e];
            while (p >= k) {
                p /= nums[s];
                s++;
            }
            count += (e-s+1);
        }
        return count;
        
    }
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        subarrayprodlessthanK obj = new subarrayprodlessthanK();
        int result = obj.numSubarrayProductLessThanK(nums, k);
        System.out.println(result);
    }
    
}
