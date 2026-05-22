class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] == target) {
            return 0;
        }
        if(nums[nums.length - 1] == target) {
            return nums.length -1 ;
        }
        int l = 0; 
        int r = nums.length - 1;
        int mid = (l + r) / 2;
        while(target != nums[mid]) 
        {
            if((nums[mid] < nums[r] && (target > nums[r] || target < nums[mid])) || (nums[mid] > nums[r] && target < nums[mid] && target > nums[r])) 
            {
                r = mid;
            } else 
            {
                l = mid;
            }
            if(mid == (l + r)/2)
            {
                mid = -1;
                break;
            }
            mid = (l + r) /2;
        }
        return mid;
        
    }
}