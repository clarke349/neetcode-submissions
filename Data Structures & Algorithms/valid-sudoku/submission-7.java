class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int N = board.length;
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char current = board[r][c];
                if (current == '.') continue;

                String squareKey = r / 3 + ", " + c / 3;

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(current)
                || cols.computeIfAbsent(c, k -> new HashSet<>()).contains(current)
                || squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(current)) {
                    return false;
                }

                rows.get(r).add(current);
                cols.get(c).add(current);
                squares.get(squareKey).add(current);
            }
        }

        return true;
    }
}
