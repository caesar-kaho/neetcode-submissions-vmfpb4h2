class Solution {
    private int ROWS, COLS;
    private Set<Pair<Integer, Integer>> visited = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int i) {
        if (i == word.length()) {
            return true;
        }
        Pair<Integer, Integer> location = new Pair<>(row, col);

        if (row < 0 || col < 0 || 
            row >= ROWS || col >= COLS || 
            board[row][col] != word.charAt(i) ||
            visited.contains(location)) {
                return false;
            }

        visited.add(location);
        boolean res = dfs(board, word, row + 1, col, i + 1)||
                        dfs(board, word, row - 1, col, i + 1)||
                        dfs(board, word, row, col + 1, i + 1)||
                        dfs(board, word, row, col - 1, i + 1);

        visited.remove(location);

        return res;
    }
}
