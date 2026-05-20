class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] st = t.toCharArray();

        Arrays.sort(sc);
        Arrays.sort(st);

        for(int i=0;i<sc.length;i++)
        {
            if(sc[i]!=st[i])
            {
                return false;
            }
        }
        return true;
    }
}
