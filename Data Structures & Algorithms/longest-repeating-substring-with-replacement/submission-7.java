/* Brute force - O(N2) as finding all substrings and then identifying which one will be the largest on removal of k characters
Optimal - O(N) - Using sliding window and 2 pointer approach, and a hshmap to store count of each character
*/
class Solution {
    public int characterReplacement(String s, int k) {
	HashMap<Character, Integer> map = new HashMap<>();
	char[] ch = s.toCharArray();
	int n = ch.length;
	int result = 0;
	int left = 0;
	int right = 0;
	
	while(right<n)
	{
		map.put(ch[right], map.getOrDefault(ch[right], 0)+1);
		int curr_window = right - left + 1;
		int max_freq = Collections.max(map.values()); 
		
		while(curr_window-max_freq>k)
		{
			map.put(ch[left], map.getOrDefault(ch[left], 0)-1);
			if(map.get(ch[left])<=0)
			{
				map.remove(ch[left]);
			}
			left++;
			curr_window = right - left + 1;
            if(!map.isEmpty())
            {
			    max_freq = Collections.max(map.values());
            }
		}
   		result = curr_window>result?curr_window:result;
		right++;
	}
	return result;
    }
}