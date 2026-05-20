class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int total = 0;
        int left=0, right=n-1;
        int max_left=0, max_right=0;
        while(left<right)
        {
            if(height[left]<height[right])
            {
                if(height[left]>=max_left)
                {
                    max_left=height[left];
                }
                else
                {
                    total+=max_left-height[left];
                }
                left++;
            }
            else
            {
                if(height[right]>=max_right)
                {
                    max_right=height[right];
                }
                else
                {
                    total+=max_right-height[right];
                }
                right--;
            }
        }
        return total;
    }
}