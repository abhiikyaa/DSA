class Solution {
    public int[] separateDigits(int[] arr) {
        int totalDigits = 0;
        for (int n : arr) 
        {
            int temp = n;

            if (temp == 0) totalDigits++;
            else 
            {
                while (temp > 0) 
                {
                    totalDigits++;
                    temp /= 10;
                }
            }
        }

        int[] ans = new int[totalDigits];
        int index = totalDigits - 1;
        for (int i = arr.length - 1; i >= 0; i--) 
        {
            int num = arr[i];
            if(num == 0) ans[index--] = 0;
            else
            {
                while (num > 0) 
                {
                    ans[index--] = num % 10;
                    num /= 10;
                }
            }
        }
        return ans;
    }
}
// class Solution {
//     public int[] separateDigits(int[] nums) {
//         int n = nums.length;
//         ArrayList<Integer> list = new ArrayList<>();
//         for(int num : nums)
//         {
//             ArrayList<Integer> temp = new ArrayList<>();
//             while(num>0)
//             {
//                 int dig = num%10;
//                 temp.add(dig);
//                 num = num/10;
//             }
//             for(int i=0; i<temp.size(); i++)
//             {
//                 list.add(temp.get(temp.size()-i-1));
//             }
//         }

//         int[] ans = new int[list.size()];
//         for(int i=0; i<list.size(); i++)
//         {
//             ans[i] = list.get(i);
//         }
//         return ans;
//     }
// }

