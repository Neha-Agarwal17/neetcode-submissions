/*
Sliding window - i and j 2 pointer, i =0, j=i+1, iterate j till n , sum will store the sum, count will store the size of subarray, j++ 
if(sum>=target), loop until(sum - nums[i]>=target) is true, i++, count --;
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i=0;
        int j = 0;
        int count = 0;
        int min_count = Integer.MAX_VALUE;
        int sum = 0;
        while(j<n)
        {
            sum = sum + nums[j];
            j++;
            count++;
            while(sum>=target)
            {
                min_count = count<min_count?count:min_count;
                sum = sum - nums[i];
                i++;
                count--;
            }
        }
        if(min_count==Integer.MAX_VALUE) return 0;
        return min_count;
    }
}