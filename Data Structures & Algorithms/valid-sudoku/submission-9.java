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

                // Use the fact that Set.add() returns false when the value is already there.
                // This way we don't need to call get() and then do an additional call
                // later to do the add. We do it all in one step.
                if (!rows.computeIfAbsent(r, k -> new HashSet<>()).add(current)
                || !cols.computeIfAbsent(c, k -> new HashSet<>()).add(current)
                || !squares.computeIfAbsent(squareKey, k -> new HashSet<>()).add(current)) {
                    return false;
                }
            }
        }

        return true;
    }
}
