class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        Map<Character, Integer> m1 = new HashMap<>();

        for (char c: s1.toCharArray()) {
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }

        int need = m1.size();
        for (int i = 0; i < s2.length(); i ++) {
            Map<Character,Integer> m2 = new HashMap<>();
            int cur = 0;
            for (int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                m2.put(c, m2.getOrDefault(c, 0) + 1);

                if (m1.getOrDefault(c, 0) < m2.get(c)) {
                    break;
                }

                if (m1.getOrDefault(c, 0) == m2.get(c)) {
                    cur++;
                }

                if (cur == need) {
                    return true;
                }
            }
        }
        return false;
    }
}
