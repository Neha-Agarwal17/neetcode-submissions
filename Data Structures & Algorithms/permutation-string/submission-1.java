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
        int i=0;
        while(i<c1.length)
        {
            ++f1[c1[i]-'a'];
            ++f2[c2[i]-'a'];
            i++;
        }
        if(Arrays.equals(f1,f2))
        {
            return true;
        }
        i=0;
        int j =c1.length;
        while(j<c2.length)
        {
            --f2[c2[i++]-'a'];
            ++f2[c2[j++]-'a'];
            if(Arrays.equals(f1,f2))
            {
                return true;
            }
        }
        return false;
    }
}
