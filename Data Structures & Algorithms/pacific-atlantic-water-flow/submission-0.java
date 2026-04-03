class Solution {
    private int[][] directions = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            // top row
            dfs(0, c, pac, heights);
            // bottom row
            dfs(ROWS - 1, c, atl, heights);
        }

        for (int r = 0; r < ROWS; r ++) {
            // left col
            dfs(r, 0, pac, heights);
            // right col
            dfs(r, COLS - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                } 
            }
        }

        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        for (int[] dir: directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < heights.length &&
                nc >= 0 && nc < heights[0].length &&
                heights[r][c] <= heights[nr][nc] &&
                !ocean[nr][nc]) {
                    dfs(nr, nc, ocean, heights);
                }
        }
    }
}
