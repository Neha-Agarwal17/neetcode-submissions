class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        List<Integer>[] bucket = (List<Integer>[]) new List[nums.length+1];

        for(int key: map.keySet())
        {
            int freq = map.get(key);
            if(bucket[freq] == null)
            {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int count=0;
        int[] result = new int[k];
        for(int i=bucket.length-1; i>=0 && count<k;i--)
        {
           if(bucket[i]!=null)
           {
            for(int num:bucket[i])
            {
                result[count] = num;
                count++;
                if(count>k)
                {
                    return result;
                }
            }
           }
        }
        return result;
    }
}
