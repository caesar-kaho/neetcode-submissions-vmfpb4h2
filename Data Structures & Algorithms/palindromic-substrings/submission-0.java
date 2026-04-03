class Solution {
    public int countSubstrings(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i ++) {
            int l = i;
            int r = i;

            while(l >= 0 && l < s.length() && r >= 0 && r < s.length()
            && s.charAt(l) == s.charAt(r)) {
                res.add(s.substring(l, r));
                l --;
                r ++;
            }

            l = i;
            r = i + 1;

            while(l >= 0 && l < s.length() && r >= 0 && r < s.length()
            && s.charAt(l) == s.charAt(r)) {
                res.add(s.substring(l, r));
                l--;
                r++;
            }
        }

        return res.size();
    }
}
