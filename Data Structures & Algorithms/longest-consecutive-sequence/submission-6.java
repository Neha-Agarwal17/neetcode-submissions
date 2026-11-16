//  hashset -> 9,1,4,3,7,-1,0,5,8,6 to avoid duplicates
// set.contains(s+1)
// set a start point based on if s-1 is not present, loop until we get s+1 and keep increasing counter
// check everytime for a start count>maxCount, if yes update maxCount.
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }
        int count = 1;
        int max = 0;
        for(int s: set)
        {
            if(!set.contains(s-1))
            {
                while(set.contains(s+1))
                {
                    s++;
                    count++;
                }
                max=count>max?count:max;
                count=1;
            }
        }
        return max;
    }
}
