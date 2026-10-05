//sort each string and store the string in map as per sorted key
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String key = String.valueOf(s);
            if(!map.containsKey(key))
            {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
