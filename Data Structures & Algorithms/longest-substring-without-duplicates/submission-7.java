/*
HashMap to store freq - 
left - 0, right - 0 start by z , put z,1
check window valid or not -> Max value in map.values <= 1, if > window_invalid, 
remove left entry from map , left ++ -> until window is valid again 
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        int n = ch.length;
        int max = 0;
        int res = 0;
        if(s==null || s.length()==0)
        {
            return 0;
        }
        while(right<n)
        {
            map.put(ch[right], map.getOrDefault(ch[right], 0)+1);
            max = Collections.max(map.values());
            while(max>1)
            {
                map.put(ch[left], map.getOrDefault(ch[left], 0)-1);
                if(map.get(ch[left]) == 0)
                {
                    map.remove(ch[left]);
                }
                left++;
                max = Collections.max(map.values());
            }
            int win_size = right - left + 1;
            res = win_size>res?win_size:res;
            right++;
        }
        return res;
    }
}
