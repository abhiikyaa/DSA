class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int l = (int)(Math.log(n) / Math.log(2)) + 1;
        int m = (1 << l) - 1;
        return n ^ m;
    }
}