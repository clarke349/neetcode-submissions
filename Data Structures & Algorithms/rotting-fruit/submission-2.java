class Solution {
    private final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        final int ROWS = grid.length;
        final int COLS = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int current = grid[r][c];
                if (current == 1) {
                    fresh++;
                } else if (current == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int time = 0;
        while (!q.isEmpty() && fresh > 0) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int[] current = q.poll();

                for (int[] d : DIRS) {
                    int r = d[0] + current[0];
                    int c = d[1] + current[1];
                    if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] != 1) continue;
                    grid[r][c] = 2;
                    q.offer(new int[]{r, c});
                    fresh--;
                }
            }
            time++;
        }

        if (fresh != 0) return -1;
        return time;
    }
}
