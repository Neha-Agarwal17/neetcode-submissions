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
        while(i<n)
        {
            if(!set.contains(c[i]))
            {
                set.add(c[i]);
                i++;
                count++;
            }
            else
            {
                i=j+1;
                j++;
                count=0;
                set.clear();
            }
            maxCount= count>maxCount ? count : maxCount;
        }
        return maxCount;
    }
}
