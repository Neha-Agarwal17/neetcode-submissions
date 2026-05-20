class Solution {
    public int maxArea(int[] nums) {
        int max = 0;
        int n = nums.length;
        /*BRUTE FORCE -
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
        */
        int i =0;
        int j=n-1;
        while(i<j)
        {
            int x = j-i;
            int y = nums[i]<nums[j]?nums[i]:nums[j];
            int mul = x*y;
            max = max > mul ? max : mul;
            if(nums[i]<nums[j])
            {
                i++;
            }
            else if(nums[j]<nums[i])
            {
                j--;
            }
            else{
                if(nums[i+1]>nums[j-1]){i++;}
                else{j--;}
           }
        }
        return max;
    }
}
