class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int next = target-nums[i];
            if(map.containsKey(next))
            {
                int j=map.get(next);
                return (i<j) ? new int[] {i,j} : new int[]{j,i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1,-1};
    }
}
