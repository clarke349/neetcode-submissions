class Solution {
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][COLS - 1] == 'O') {
                dfs(board, r, COLS - 1);
            }
        }

        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[ROWS - 1][c] == 'O') {
                dfs(board, ROWS - 1, c);
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
        
    }

    private void dfs(char[][] board, int r, int c) {
        int ROWS = board.length;
        int COLS = board[0].length;

        if (r < 0 || r >= ROWS) return;
        if (c < 0 || c >= COLS) return;
        if (board[r][c] != 'O') return;

        board[r][c] = 'T';
        for (int[] dir : directions) {
            dfs(board, r + dir[0], c + dir[1]);
        }
    }
}
