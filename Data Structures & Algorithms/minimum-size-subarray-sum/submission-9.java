class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int res = n;
        int left = 0;
        int right = 0;
        int sum = 0;
        boolean found = false;
        while(right<n)
        {
            sum+=nums[right];
            while((sum - nums[left])>=target)
            {
                sum = sum - nums[left];
                left++;
            }
            if(sum>=target)
            {
                int win_size = right-left+1;
                res = win_size<res?win_size:res;
                found = true;
            }
            right++;
        }
        if(found) {return res;}
        return 0;
    }
}