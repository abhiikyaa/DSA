public class removeElement27 {

    public static void swap(int[] arr, int start, int end) {
        int temp = 0;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                if (nums[j] == val) {
                    j--;
                }else {
                    swap(nums, i, j);
                    j--;
                    i++;
                }
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        removeElement27 obj = new removeElement27();
        int newLength = obj.removeElement(nums, val);

        System.out.println("New Length: " + newLength);
        System.out.print("Modified Array: ");
        for (int k = 0; k < newLength; k++) {
            System.out.print(nums[k] + " ");
        }    

    }
}
    




        