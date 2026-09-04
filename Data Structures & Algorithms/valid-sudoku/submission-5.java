class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char currentSquare = board[r][c];
                if (currentSquare == '.')
                    continue;

                String square = r / 3 + ", " + c / 3;

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(currentSquare)
                    || cols.computeIfAbsent(c, k -> new HashSet<>()).contains(currentSquare)
                    || squares.computeIfAbsent(square, k -> new HashSet<>()).contains(currentSquare)) {
                    return false;
                }

                rows.get(r).add(currentSquare);
                cols.get(c).add(currentSquare);
                squares.get(square).add(currentSquare);
            }
        }
        return true;
    }
}
