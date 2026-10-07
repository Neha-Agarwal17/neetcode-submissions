class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        // 1. Count frequencies
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        // 2. Sort entries by value descending and collect keys into a list
        List<Integer> list = map.entrySet().stream()
                                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toList());
        
        // 3. Extract the top K elements into the result array
        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            res[i] = list.get(i);
            i++; // Fixed: Added increment to prevent infinite loop
        }
        return res;        
    }
}
