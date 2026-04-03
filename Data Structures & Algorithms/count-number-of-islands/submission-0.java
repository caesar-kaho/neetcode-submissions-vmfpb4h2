class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0},
                                               {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int island = 0;

        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    island++;
                }
            }
        }

        return island;
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = '0';
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for (int [] dir: directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
