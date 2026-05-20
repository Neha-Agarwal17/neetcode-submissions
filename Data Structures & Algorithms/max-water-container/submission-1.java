class Solution {
    public int maxArea(int[] nums) {
        int max = 0;
        int n = nums.length;
        for(int i=0;i<n-1;i++)
        {
            int j =i+1;
            while(j<n)
            {
                int x = j-i;
                int y = nums[i]<nums[j]?nums[i]:nums[j];
                int mul = x*y;
                max = max > mul ? max : mul;
                j++;
            }
        }
        return max;
    }
}
