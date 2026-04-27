class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int s = prices[0];
        int m = 0;
        for(int i = 1; i < n; i++){
            if(prices[i-1] > prices[i]){
                int p = prices[i-1] - s;
                m += p;
                s = prices[i];
            }
        }
        m += prices[n-1] - s; 
        return m;
    }
}






