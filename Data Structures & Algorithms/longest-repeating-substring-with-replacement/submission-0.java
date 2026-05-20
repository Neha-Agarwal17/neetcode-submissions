class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int response = 0;
        int curr_win = 0;
        int max = 0;
        char[] c = s.toCharArray();
        while(r<n)
        {
            if(!map.containsKey(c[r]))
            {
                map.put(c[r], 1);
            }
            else
            {
                map.put(c[r], map.get(c[r])+1);
            }
            curr_win++;
            max = Collections.max(map.values());
            int rep_count = curr_win - max;
            if(rep_count<=k)
            {
                r++;
            }
            else
            {
                map.put(c[l], map.get(c[l])-1);
                l++;
                r++;
                curr_win--;
            }
            response = curr_win;
        }
        return response;
    }
}
