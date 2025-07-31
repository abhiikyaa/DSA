public class MaxArea {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int w = r - l;
            int h = Math.min(height[l] , height[r]);
            int a = w * h;
            max = Math.max(max,a);
            if (height[l] < height[r]){
                l++;
            }
            else if (height[l] > height[r]){
                r--;
            }
            else{
                l++;
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height ={1,8,6,2,5,4,8,3,7};
        MaxArea obj = new MaxArea();
        int solu = obj.maxArea(height);
        System.out.print("max area :" + solu);

    }
    
}
