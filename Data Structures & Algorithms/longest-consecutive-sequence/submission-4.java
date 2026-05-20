//  hashset -> 9,1,4,3,7,-1,0,5,8,6 to avoid duplicates
// set.contains(s+1)
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int maxCount=1;
        HashSet<Integer> set = new HashSet<>();
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 1;
        }
        for(int i=0;i<n;i++)
        {
            if(!set.contains(nums[i]))
            {
                set.add(nums[i]);
            }
        }
        //for neg+pos values -> 9,1,4,3,7,-1,0,5,8,6
        for(int s : set)
        {
            int count =1;
            if(!set.contains(s-1))
            {
                int start = s;
                while(set.contains(start+1)){
                    count++;
                    start++;
                }
                if(count>maxCount){
                    maxCount=count;
                }
            }
        }
        return maxCount;   
    }
}
