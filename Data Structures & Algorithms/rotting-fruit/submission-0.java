class Solution {

    private int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public int orangesRotting(int[][] grid) {

        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // 掃描 grid
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {

                if (grid[r][c] == 1) {
                    fresh++;
                }

                if (grid[r][c] == 2) {
                    q.offer(new int[]{r,c});
                }
            }
        }

        int time = 0;

        // BFS
        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                for (int[] d : directions) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < ROWS &&
                        nc >= 0 && nc < COLS &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}