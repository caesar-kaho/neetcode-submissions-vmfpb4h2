class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int left = 0;
        int highestFreq = 0;
        Map<Character, Integer> countMap = new HashMap<>();

        for (int r = 0; r < s.length(); r ++) {
            countMap.put(s.charAt(r), countMap.getOrDefault(s.charAt(r), 0) + 1);
            highestFreq = Math.max(countMap.get(s.charAt(r)), highestFreq);

            while((r - left + 1) - highestFreq > k) {
                countMap.put(s.charAt(left), countMap.get(s.charAt(left)) - 1);
                left++;
            }

            res = Math.max(res, (r - left + 1));
        }
        return res;
    }
}
