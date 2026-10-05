class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);
        String newS = String.valueOf(sArr);
        String newT = String.valueOf(tArr);
        return newS.equals(newT);
    }
}
