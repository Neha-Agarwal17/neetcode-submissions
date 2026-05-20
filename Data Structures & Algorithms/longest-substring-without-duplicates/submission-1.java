class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        if(n == 0)
        {
            return 0;
        }
        int i=0;
        int j=0;
        char[] c = s.toCharArray();
        int maxCount=0;
        int count=0;
        while(j<n)
        {
            if(!set.contains(c[j]))
            {
                set.add(c[j]);
                count++;
                j++;
                maxCount= count>maxCount ? count : maxCount;
            }
            else
            {
                set.remove(c[i]);
                i++;
                count--;
            }
        }
        return maxCount;
    }
}
