/*
Brute force - The $O(n^2)$ "Restart" Approach.
This method handles duplicates by clearing its entire memory and starting the search over from the next character in line.
Because it re-visits the same characters multiple times,
its performance drops significantly as your input string gets longer.

Optimal solution - The $O(n)$ "Sliding Window" Approach.
This approach optimizes progress by only removing the specific characters that cause a conflict, 
keeping the rest of the valid window intact.Since both pointers only ever move forward, 
every character is processed exactly once, allowing the code to stay fast regardless of string size.
*/
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
