/*
    FreqMap -
    A - 2
    B - 2
    how do we know if the current element is max count
    WINDOW SIZE = 1
    put freq of current element in map
    max = get the maximum of map.values()
    window_size = right - left + 1;
    window_size - max<=k, proceed
*/
class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0, right = 0;
        char[] ch = s.toCharArray();
        int window_size = 0;
        int max = 0;
        int res = 0;
        while(right<n)
        {
            map.put(ch[right], map.getOrDefault(ch[right], 0)+1);
            max = Collections.max(map.values());
            window_size = right - left + 1;
            while(window_size - max > k)
            {
                map.put(ch[left], map.getOrDefault(ch[left], 0)-1);
                if(map.get(ch[left]) == 0)
                {
                    map.remove(ch[left]);
                }
                left++;
                window_size = right - left + 1;
                if(!map.isEmpty())
                {
                    max = Collections.max(map.values());
                }
            }
            right++;
            res = window_size>res?window_size:res;
        }
        return res;
    }
}
