class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxD = 0;
        for(int i = 0; i < n; i++){
            if(colors[i] != colors[n-1]){
                maxD = Math.max(maxD,(n-1) - i );
                break;
            }
        }
        for(int i = n-1; i >= 0; i--){
            if(colors[0] != colors[i]){
                maxD = Math.max(maxD, i);
                break;
            }
        }
        return maxD;
    }
}