class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;
        int  l = 0;

        for (int r = 0; r < arr.length; r++){
            sum += arr[r];
            while (r - l + 1 >= k){
                if(sum/k >= threshold){
                    count++;
                }
                sum -= arr[l];
                l++;
            }

        }
        return count;
    }
}