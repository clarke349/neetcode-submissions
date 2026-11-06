class Solution {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;

        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                }
            }
        }

        return bfs(grid, fresh, q);
    }

    private int bfs(int[][] grid, int fresh, Queue<int[]> q) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int time = 0;

        while (fresh > 0 && !q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int[] current = q.poll();
                int r = current[0];
                int c = current[1];

                for (int[] d : directions) {
                    int row = r + d[0];
                    int col = c + d[1];

                    if (row < 0 || row >= ROWS) continue;
                    if (col < 0 || col >= COLS) continue;
                    if (grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }

        if (fresh != 0) return - 1;

        return time;
    }
}
