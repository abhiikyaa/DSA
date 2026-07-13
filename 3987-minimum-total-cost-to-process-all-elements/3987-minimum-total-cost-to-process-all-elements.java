class Solution {
    public int minimumCost(int[] nums, int k) {
        long mod=1000000007;
        long curRes=k;
        long totalOps=0;
        for(int num:nums){
            if(curRes<num){
                long need=num-curRes;
                long opsNeed=(need+k-1)/k;
                totalOps=totalOps+opsNeed;
                curRes=curRes+opsNeed*k;
            }
            curRes=curRes-num;
        }
        long n1=totalOps%mod;
        long n2=(totalOps+1)%mod;
        long totalCost=(n1*n2)%mod;
        totalCost=(totalCost*500000004)%mod;
        return (int) totalCost;
    }
}