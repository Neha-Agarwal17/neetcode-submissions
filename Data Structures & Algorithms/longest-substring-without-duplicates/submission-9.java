class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
        {
            return 0;
        }
        int n = s.length();
        Boolean flag = false;
        char first = s.charAt(0);
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)!= first)
            {
                flag = true;
            }
        }
        int max_count=1;
        if(flag == false)
        {
            return max_count;
        }
        else
        {
            HashSet<Character> set = new HashSet<>();
            int left=0;
            int right=0;
            int c=0;
            for(right =0; right<n; right++)
            {
                while(set.contains(s.charAt(right)))
                {
                    set.remove(s.charAt(left));
                    left++;
                    c--;
                }
                set.add(s.charAt(right));
                c++;
                max_count = c>max_count?c:max_count;
            }
        }
        return max_count;
    }
}
