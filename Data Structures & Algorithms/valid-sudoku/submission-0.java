class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.')
                    continue;

                String squareKey = (r / 3) + "," + (c / 3);

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(val)
                    || cols.computeIfAbsent(c, k -> new HashSet<>()).contains(val)
                    || squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(val)) {
                    return false;
                }

                rows.get(r).add(val);
                cols.get(c).add(val);
                squares.get(squareKey).add(val);
            }
        }
        return true;
    }
}
