class Solution {
    public int largestAltitude(int[] gain) {
        int [] prefix = new int[gain.length + 1];

        int maxAlt = 0;
        prefix[0] = 0;

        for(int i = 1; i <= gain.length; i++){
            prefix[i] = prefix[i - 1] + gain[i - 1];
            maxAlt = Math.max(maxAlt , prefix[i]);
        }
        return maxAlt;
    }
}