class Solution {
    public int numDistinct(String s, String t) {
        if (s.equals("")) return 0;
        if (t.equals("")) return 1;

        return dfs(s, t, 0, 0);

    }

    private int dfs(String s, String t, int i, int j) {
        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        int count = dfs(s, t, i + 1, j);
        
        if (s.charAt(i) == t.charAt(j)) {
            count += dfs(s, t, i + 1, j + 1);
        }

        return count;
    }
}
