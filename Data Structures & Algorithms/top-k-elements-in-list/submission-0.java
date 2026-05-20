class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums)
        {
            int count = map.containsKey(n)?map.get(n):0;
            map.put(n, ++count);
        }
        List<Integer>[] buckets = (List<Integer>[]) new List[nums.length+1];

        for(int key : map.keySet())
        {
            int freq = map.get(key);
            if(buckets[freq]==null)
            {
                buckets[freq]=new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        int count =0;
        int[] res = new int[k];
        for(int i = buckets.length-1; i>0 && count<k;i--)
        {
            if(buckets[i]!=null)
            {
                for(int n: buckets[i])
                {
                    res[count++]=n;
                    if(count>k){return res;}
                }
            }
        }
        return res;
    }
}
