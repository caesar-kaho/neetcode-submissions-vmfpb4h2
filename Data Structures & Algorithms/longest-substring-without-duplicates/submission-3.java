class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        Map<Character, Integer> seen = new HashMap<>();

        for (int r = 0; r < s.length(); r ++) {
            if (seen.containsKey(s.charAt(r))) {
                left = Math.max(left, seen.get(s.charAt(r)) + 1);
            }
                seen.put(s.charAt(r), r);
                res = Math.max(res, r - left + 1);
            
        }

        return res;
    }
}
