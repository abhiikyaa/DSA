class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        int ans = 2 * n;

        Arrays.sort(reservedSeats, (a, b) -> a[0] - b[0]);

        int i = 0;

        while (i < reservedSeats.length) {

            int row = reservedSeats[i][0];
            int mask = 0;

            // Store reserved seats of this row
            while (i < reservedSeats.length &&
                   reservedSeats[i][0] == row) {

                int seat = reservedSeats[i][1];
                mask |= (1 << seat);

                i++;
            }

            // 2,3,4,5
            int first = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);

            // 4,5,6,7
            int second = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);

            // 6,7,8,9
            int third = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

            boolean Fsec = (mask & first) == 0;
            boolean Ssec = (mask & second) == 0;
            boolean Tsec = (mask & third) == 0;

            if (Fsec && Tsec) {
                // 2 families
            }
            else if (Fsec || Ssec || Tsec) {
                ans--;
            }
            else {
                ans -= 2;
            }
        }

        return ans;
    }
}