class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int islands = 0;

        // We travers the grid to find land. If land is found,
        // we can incrment the number of islands. We can do this
        // because our dfs algorithm destroys land as it finds them
        // (i.e. turns a 1 into a 0). Therefore, when we find new
        // land, we can guarantee that it is land that we have not
        // seen (otherwise it would have been destroyed).
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    // traverses island given a starting point and
    // destroys land as it traverses.
    private void dfs(char[][] grid, int r, int c) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        if (r < 0 || r >= ROWS) return;
        if (c < 0 || c >= COLS) return;
        if (grid[r][c] == '0') return;

        // We have found land, so we "destroy" it to
        // indicate that it has already been visited
        grid[r][c] = '0';
        for (int[] dir : directions) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}
