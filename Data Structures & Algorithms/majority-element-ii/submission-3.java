/*
Sorting not allowed - O(nlogn)
Maps not allowed - O(n)
O(1) and O(N)
n = 10 - n/3 = 10/3 = 3
freq>3

count = 0;
how many elements can be greater then n/3? - at most 2
candidate1 and candidate2
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<n; i++)
        {
            if(nums[i]==candidate1)
            {
                count1++;
            }
            else if(nums[i]==candidate2)
            {
                count2++;
            }
            else if(count1==0)
            {
                candidate1=nums[i];
                count1=1;
            }
            else if(count2==0)
            {
                candidate2=nums[i];
                count2=1;
            }
            else
            {
                count1--;
                count2--;
            }
        }

        // Verification pass
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }
        List<Integer> res = new ArrayList<>();
        if(count1>n/3){
            res.add(candidate1);
        }
        if(count2>n/3){
            res.add(candidate2);
        }
        return res;
    }
}