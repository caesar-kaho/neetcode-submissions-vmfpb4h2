class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        dfs(res, cur, s, 0);

        return res;
    }

    private void dfs(List<List<String>> res, List<String> cur, String s, int i) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < s.length(); j ++) {
            if (isPali(s, i, j)) {
                cur.add(s.substring(i, j + 1));
                dfs(res, cur, s, j + 1);
                cur.remove(cur.size() - 1);
            }
        }
        
    }

    private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
