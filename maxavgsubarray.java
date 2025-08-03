public class maxavgsubarray {
    public double findMaxAverage(int[] nums, int k) {
        
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        
        for (int end = k; end < nums.length; end++) {
            sum += nums[end];           
            sum -= nums[end - k];       
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        maxavgsubarray obj = new maxavgsubarray();
        double result = obj.findMaxAverage(nums, k);
        System.out.println("Maximum Average: " + result);
    }
}
