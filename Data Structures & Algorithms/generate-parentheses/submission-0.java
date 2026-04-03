class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        backtrack(n, cur, 0, 0);
        return res;
    }

    private void backtrack(int n, StringBuilder cur, int open, int close) {
        if (open == close && open == n) {
            res.add(cur.toString());
            return;
        }

        if (open < n) {
            // add open
            cur.append("(");
            backtrack(n, cur, open + 1, close);
            cur.deleteCharAt(cur.length() - 1);
        }

        // add close
        if (close < open) {
            cur.append(")");
            backtrack(n, cur, open, close + 1);
            cur.deleteCharAt(cur.length() - 1);
        }

    }
}
