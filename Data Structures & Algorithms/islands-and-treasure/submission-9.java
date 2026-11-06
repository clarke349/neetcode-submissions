class Solution {
    private static final int INF = 2147483647;
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int ROWS, COLS;

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();

        // Start BFS from every treasure chest at the same time.
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    q.add(new int[] {r, c});
                }
            }
        }

        bfs(grid, q);
    }

    // Expand from all treasures at once
    private void bfs(int[][] grid, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : DIRS) {
                int nr = r + d[0];
                int nc = c + d[1];

                // Only visit in-bounds land that hasn't been reached yet.
                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] != INF) {
                    continue;
                }
                grid[nr][nc] = grid[r][c] + 1;
                q.offer(new int[] {nr, nc});
            }
        }
    }
}
