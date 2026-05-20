//-ves++ves+0s Array - sort the array
//Loop through the array and avoid duplicates
// Also if i>0 then we should break, because we won't be able to get 0 from the next elements after i
// 2 pointers - one at the next of i and one at the end of the arr- n-1
//  loop until left < right;
// if(sum of elements at i, left, right ==0), store the results
// again avoid duplicates (left++, right--)
// return response
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++)
        {
            if(nums[i]>0)
            {
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){continue;}
            int left = i+1;
            int right = n-1;
            while(left<right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0)
                {
                    res.add(List.of(nums[i],nums[left], nums[right]));
                    while(left<right && nums[left]==nums[left+1]){left++;}
                    while(left<right && nums[right]==nums[right-1]){right--;}
                    left++;
                    right--;
                }
                else if(sum<0)
                {
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return res;    
    }
}
