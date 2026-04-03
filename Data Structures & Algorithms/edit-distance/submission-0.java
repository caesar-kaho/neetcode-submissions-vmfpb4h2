class Solution {
    int ROWS;
    int COLS;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        ROWS = word1.length();
        COLS = word2.length();

        dp = new int[ROWS + 1][COLS + 1];
        dp[ROWS][COLS] = 0;

        for (int r = 0; r < ROWS; r ++) {
            dp[r][COLS] = ROWS - r;
        }

        for (int c = 0; c < COLS; c ++) {
            dp[ROWS][c] = COLS - c;
        }

        for (int r = ROWS - 1; r >= 0; r --) {
            for (int c = COLS - 1; c >= 0; c --) {
                if (word1.charAt(r) == word2.charAt(c)) {
                    dp[r][c] = dp[r + 1][c + 1];
                }else {
                    dp[r][c] = 1 + Math.min(dp[r][c + 1], 
                                    Math.min(dp[r + 1][c],
                                    dp[r + 1][c + 1]));
                }
            }
        }

        return dp[0][0];

    }
}
