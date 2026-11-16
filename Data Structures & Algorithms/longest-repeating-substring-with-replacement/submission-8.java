/*
AAABABB - 

MAX NO. OF REPLACEMENTS ALLOWED - K = 1
left - A
right - A
freqMap - A - 1
left = A
right = A
freqMap - 
A - 2 
A - 3
B - 1
IS OUR WINDOW VALID? 
- window_size - 3-0+1 = 4 
- maxfreq = maximum freq in our map = 3
(window_size-maxfreq) = 4-3 = 1<=k - window is fine proceed (STORE AND PROCEED)
freqMap -
A - 4
B - 1
IS OUR WINDOW VALID? 
- window_size - 4-0+1 = 5 
- maxfreq = maximum freq in our map = 4
(window_size-maxfreq) = 5-4 = 1<=k - window is fine proceed (STORE AND PROCEED)
A - 4
B - 2
IS OUR WINDOW VALID? 
- window_size - 5-0+1 = 6 
- maxfreq = maximum freq in our map = 4
(window_size-maxfreq) = 6-4 = 2>k - window is invalid 
    - remove freqMap[left]
    - reduce window size until window is valid and proceed
*/

class Solution {
    public int characterReplacement(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        if(k>=n)
        {
            return n;
        }
        while(right<n)
        {
            map.put(ch[right],map.getOrDefault(ch[right], 0)+1);
            int win_size = right-left+1;
            int max_freq = Collections.max(map.values());
            while(win_size-max_freq>k)
            {
                map.put(ch[left], map.get(ch[left])-1);
                if(map.get(ch[left]) == 0)
                {
                    map.remove(ch[left]);
                }
                left++;
                win_size = right - left + 1;
                max_freq = Collections.max(map.values());
            }
            result = win_size>result?win_size:result;
            right++; 
        }
        return result;    
    }
}
