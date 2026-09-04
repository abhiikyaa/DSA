class Solution {
    public int[] replaceElements(int[] arr) 
    {
        int n = arr.length;
        if(n == 1) return new int[]{-1};
        int[] ans = new int[n];
        ans[n-1] = -1;
        for(int i = n-2; i >= 0; i--)
        {
            if(arr[i+1] > ans[i+1])
            {
                ans[i] = arr[i+1];
            }
            else ans[i] = ans[i+1];
        }
        return ans;

    }
}