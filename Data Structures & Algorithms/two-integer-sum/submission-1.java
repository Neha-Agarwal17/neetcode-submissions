class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            map.put(nums[i], i);
        }
        int[] res = new int[2];
        for(int i=0;i<n;i++)
        {
            int diff = target - nums[i];
            if(map.containsKey(diff) && map.get(diff)!=i)
            {
                res[0] = i;
                res[1] = map.get(diff);
                return res;
            }
        }
        return res;
    }
}
