class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int c = 0;
        int[] ans = new int[n];
        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++)
        {
            if(vis[A[i] - 1])
            {
                c++;
            }
            else
            {
                vis[A[i] - 1] = true;
            }

            if(vis[B[i] - 1])
            {
                c++;
            }
            else
            {
                vis[B[i] - 1] = true;
            }

            ans[i] = c;
        } 
        return ans;
    }
}
