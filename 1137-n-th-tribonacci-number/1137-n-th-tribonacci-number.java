class Solution {
    public int tribonacci(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr,-1);  
        return recur(n,arr);      
    }
    public int recur(int n, int[]arr){
        if(n ==0) return 0;
        if(n <= 2) return 1;
        if(arr[n]!= -1) return arr[n];
        return arr[n] = recur(n-1, arr) + recur(n-2,arr) + recur(n-3,arr); 

    }
}