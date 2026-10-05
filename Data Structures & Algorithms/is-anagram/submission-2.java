class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        //1. Sorting
        // Arrays.sort(sArr);
        // Arrays.sort(tArr);
        // String newS = String.valueOf(sArr);
        // String newT = String.valueOf(tArr);
        // return newS.equals(newT);

        //2.HashMap

        if(n1!=n2)
        {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(char c: s.toCharArray())
        {
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }
        for(char c: t.toCharArray())
        {
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }

        return map1.equals(map2);
    }
}
