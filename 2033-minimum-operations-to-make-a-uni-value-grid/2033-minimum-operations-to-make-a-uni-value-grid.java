class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int[] arr = new int[m*n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int ind = i * n + j;
                arr[ind] = grid[i][j];
            }
        }

        Arrays.sort(arr);
        int len = arr.length;
        if (len == 1) return 0;
        int target = arr[len/2];

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if ((target-arr[i]) % x != 0) return -1;
            cnt += Math.abs(target-arr[i]) / x;
        }
        return cnt;
    }
}