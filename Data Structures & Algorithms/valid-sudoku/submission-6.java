class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int N = board.length;
    
        // Verify that each row is valid
        for (int r = 0; r < N; r++) {
            Set<Character> seen = new HashSet<>();
            for (int c = 0; c < N; c++) {
                char current = board[r][c];
                if (current != '.' && seen.contains(current)) return false;
                seen.add(current);
            }
        }

        // Verify that each column is valid
        for (int r = 0; r < N; r++) {
            Set<Character> seen = new HashSet<>();
            for (int c = 0; c < N; c++) {
                char current = board[c][r];
                if (current != '.' && seen.contains(current)) return false;
                seen.add(current);
            }
        }

        // Verify that each square is valid
        Map<String, Set<Character>> squares = new HashMap<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                String squareKey = r / 3 + ", " + c / 3;
                if (board[r][c] != '.' && squares.containsKey(squareKey)) {
                    Set<Character> seen = squares.get(squareKey);
                    if (seen.contains(board[r][c])) return false;
                    seen.add(board[r][c]);
                } else if (board[r][c] != '.') {
                    Set<Character> seen = new HashSet<>();
                    seen.add(board[r][c]);
                    squares.putIfAbsent(squareKey, seen);
                }
            }
        }

        return true;
    }
}
