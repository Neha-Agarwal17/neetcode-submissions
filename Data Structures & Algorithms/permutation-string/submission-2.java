class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
        {
            return false;
        }
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int left=0;
        while(left<c1.length)
        {
            ++f1[c1[left]-'a'];
            ++f2[c2[left]-'a'];
            left++;
        }
        if(Arrays.equals(f1,f2))
        {
            return true;
        }
        left=0;
        int right=c1.length;
        while(right<c2.length)
        {
            --f2[c2[left++]-'a'];
            ++f2[c2[right++]-'a'];
            if(Arrays.equals(f1,f2))
            {
                return true;
            }
        }
        return false;
    }
}
