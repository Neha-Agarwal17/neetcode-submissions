/* Brute force - O(N2) as finding all substrings and then identifying which one will be the largest on removal of k characters
Optimal - O(N) - Using sliding window and 2 pointer approach, and a hshmap to store count of each character
*/
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
            if(rep_count>k)
            {
                map.put(c[l], map.get(c[l])-1);
                l++;
                curr_win--;
            }
            r++;
            response = curr_win;
        }
        return response;
    }
}
