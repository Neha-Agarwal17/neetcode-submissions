/*
Given - 1. Only Uppercase 2. K replacements allowed
Calculate - Max length of uniform substring by making k or <k replacements

AABBAABA, 2 -> AABBA -> LEN - 5, MAX_FREQ - A, 3, 5-3=2 -> NO. OF REPLACEMENTS NEEDED

LEN - MAX_FREQ <= K <--- SUBSTRING IS VALID

BRUTE FORCE APPROACH ->
1. Store the frequency of each element in an array of fixed size 26 (A-Z)
2. having 2 loops , 1st loop give starting point for substring & 2nd loop goes till valid string
3. we can store the max_freq , len, max_len 
4. if len - max_freq <= k, valid substring

S.C - O(1), T.C - O(N2)

1. TIME COMPLEXITY IS HIGH, 2. LOT OF REPETITIVE WORK

OPTIMIZED APPROACH ->

LEN - MAX_FREQ <= K <--- SUBSTRING IS VALID

1. KEEP A WINDOW OF VALID SUBSTRING
2. 2 POINTERS - LEFT AND RIGHT
3. FREQ[] -> 26
4. MAX_FREQ -> MAXIMUM ELEMENT COUNT
5. LEN -> WINDOW SIZE
6. MAX_LEN -> RESULT
*/
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int max_len =0;
        /*
        for(int i=0;i<n;i++)
        {   
            int[] freq = new int[26];
            int max_freq=0;
            for(int j=i;j<n;j++)
            {
                freq[s.charAt(j)-'A']++;
                max_freq = Math.max(max_freq, freq[s.charAt(j)-'A']);
                int len = j-i+1;
                if(len-max_freq<=k)
                {
                    max_len = Math.max(len, max_len);
                }
                else
                {
                    break;
                }
            }
        }
        */
        int left =0, right =0;
        int[] freq = new int[26];
        int max_freq = 0;
        while(right<n)
        {
            freq[s.charAt(right)-'A']++;
            max_freq = Math.max(max_freq, freq[s.charAt(right)-'A']);
            int len = right-left+1;
            if(len - max_freq <=k)
            {
                max_len = Math.max(max_len,len);
            }
            else
            {
                freq[s.charAt(left)-'A']--;
                left++;
            }
            right++;
        }
        return max_len;
    }
}
