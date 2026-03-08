class Solution {
    public String findDifferentBinaryString(String[] nums) {
        char[] ans = new char[nums.length];

        for(int i = 0; i < nums.length; i++){
            char[] arr = nums[i].toCharArray(); 
            if(arr[i] == '0'){
            ans[i] = '1';
            }
            else{
            ans[i] = '0';
            }
        }

        return new String(ans);
    }
}