class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        boolean[][] visit = new boolean[N][N];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0]));
        int[][] directions = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        minHeap.offer(new int[]{grid[0][0], 0, 0});

        visit[0][0] = true;

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int t = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == N - 1 && c == N - 1) {
                return t;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    minHeap.offer(new int[]{Math.max(t, grid[nr][nc]), nr, nc});
                }
            }
        }

        return N * N;
    }
}
