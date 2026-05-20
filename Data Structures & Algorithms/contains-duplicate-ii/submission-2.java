/*Brute - Using HashMap -> store value and key and keep check for condition match, matches return true, else false.
Optimised solution - Using Sliding Window and HashSet, iterate through the array, if i >k(window size) remove the oldest element, 
then in hashet check if you are not able to add that means duplicate, return true 
*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*HashMap<Integer, Integer> map  = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int indx = map.get(nums[i]);
                if(i!=indx && Math.abs(i-indx)<=k)
                {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false; */

        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(i>k)
            {
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i]))
            {
                return true;
            }
        }  
        return false;
    }
}