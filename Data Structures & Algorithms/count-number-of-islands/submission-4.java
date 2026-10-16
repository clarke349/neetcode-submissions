class Solution {
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int islands = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    destroyIsland(grid, r, c);
                }
            }
        }

        return islands;
    }

    // DFS algorithm to eliminate islands based on a given
    // starting coordinates (destroying an island is the equivalent
    // of marking it as found so that we don't recount it during our traversal).
    private void destroyIsland(char[][] grid, int r, int c) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (r < 0 || r >= ROWS)
            return;
        if (c < 0 || c >= COLS)
            return;
        if (grid[r][c] == '0')
            return;

        grid[r][c] = '0';
        for (int[] dir : directions) {
            destroyIsland(grid, r + dir[0], c + dir[1]);
        }
    }
}
