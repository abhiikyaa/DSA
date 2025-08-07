import java.util.Arrays;

public class twodarraycoversion {
    public int [] [] construct2DArray(int[] original, int m, int n) {
        int[][] arr = new int[m][n];
        if (m * n != original.length) {
            return new int[0][];
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = original[index++];
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] original = {1,2,3,4};
        int m = 2;
        int n = 2;
        twodarraycoversion obj = new twodarraycoversion();
        int[] [] result = obj.construct2DArray(original, m, n);
        System.out.println(Arrays.deepToString(result));
    } 
}
