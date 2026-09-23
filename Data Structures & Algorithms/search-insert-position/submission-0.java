class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(target < nums[0])
        {
            return 0;
        }
        else if(target > nums[n-1])
        {
            return n;
        }

        int left = 0;
        int right = n-1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid]>target)
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }
        return left;
    }
}