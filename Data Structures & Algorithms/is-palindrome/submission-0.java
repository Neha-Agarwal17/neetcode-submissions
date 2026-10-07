class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] c = s.toLowerCase().toCharArray();
        while(i<j)
        {
            if(!Character.isLetterOrDigit(c[i]))
            {
                i++;
            } 
            if(!Character.isLetterOrDigit(c[j]))
            {
                j--;
            }
            if(Character.isLetterOrDigit(c[i]) &&       Character.isLetterOrDigit(c[j]))
            {
                if(c[i]!=c[j])
                {
                return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
