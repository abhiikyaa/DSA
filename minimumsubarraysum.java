public class minimumsubarraysum {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        }
        
    }

    public static void main(String[] args) {
        minimumsubarraysum obj = new minimumsubarraysum();

        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int result = obj.minSubArrayLen(target, nums);
        System.out.println("Minimum Subarray Length: " + result);
    }
}
