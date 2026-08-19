class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        int ans = 2 * n;

        HashMap<Integer, boolean[]> map = new HashMap<>();

        for (int[] s : reservedSeats) {

            int r = s[0];
            int c = s[1];

            if (!map.containsKey(r)) {
                map.put(r, new boolean[11]);
            }

            map.get(r)[c] = true;
        }

        for (int r : map.keySet()) {

            boolean[] vis = map.get(r);

            boolean Fsec = true;
            boolean Ssec = true;
            boolean Tsec = true;

            for (int j = 2; j <= 5; j++) {
                if (vis[j]) {
                    Fsec = false;
                    break;
                }
            }

            for (int j = 4; j <= 7; j++) {
                if (vis[j]) {
                    Ssec = false;
                    break;
                }
            }

            for (int j = 6; j <= 9; j++) {
                if (vis[j]) {
                    Tsec = false;
                    break;
                }
            }

            if (Fsec && Tsec) {
                
            }
            else if (Fsec || Ssec || Tsec) {
                ans -= 1;
            }
            else {
                ans -= 2;
            }
        }

        return ans;
    }
}