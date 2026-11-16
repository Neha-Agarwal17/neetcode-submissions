class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        List<Integer>[] bucket =(List<Integer>[]) new List[n+1];
        
        for(int i=0;i<n+1;i++)
        {
            bucket[i] = new ArrayList<>(); 
        }
        for(int key: map.keySet())
        {
            int freq = map.get(key);
            bucket[freq].add(key);
        }
        int i=n;
        int count = 0;
        int[] res = new int[k];
        while(i>=0 && count<k)
        {
            for(int val: bucket[i])
            {
                res[count]=val;
                count++;
                if(count==k)
                {
                    return res;
                }
            }
            i--;
        }
        return res;
    }
}
