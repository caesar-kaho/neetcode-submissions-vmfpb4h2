class Solution {
    public boolean isAnagram(String s, String t) {
        // length check
        if (s.length() != t.length()) {
            return false;
        }
        char[] charS = s.toCharArray();
        Arrays.sort(charS);
        char[] charT = t.toCharArray();
        Arrays.sort(charT);

        for (int i = 0; i < charS.length; i++) {
            if (charS[i] != charT[i]) {
                return false;
            }

        }
        return true;
    }
}
