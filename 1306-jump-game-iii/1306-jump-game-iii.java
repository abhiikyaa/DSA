class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        return solve(start,arr,vis);
     }
     public boolean solve(int i, int[] arr, boolean[] vis)
     {
        if(i < 0 || i >= arr.length) return false;
        if(vis[i]) return false;
        vis[i] = true;
        if(arr[i] == 0) return true;

        boolean fwd = solve(i+arr[i],arr,vis);
        boolean bck = solve(i-arr[i],arr,vis);

        return fwd || bck;
     }
}