class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : nums)
        {
            if(!set.add(i))
            {
                return true;
            }
        }
        return false;
    }
}