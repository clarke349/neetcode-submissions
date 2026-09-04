class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                char current = board[i][j];
                if (current == '.') continue;

                if (rows.getOrDefault(i, new HashSet<>()).contains(current)) {
                    return false;
                }
                Set<Character> updatedRowSet = new HashSet<>();
                updatedRowSet.addAll(rows.getOrDefault(i, new HashSet<>()));
                updatedRowSet.add(current);
                rows.put(i, updatedRowSet);

                if (cols.getOrDefault(j, new HashSet<>()).contains(current)) {
                    return false;
                }
                Set<Character> updatedColSet = new HashSet<>();
                updatedColSet.addAll(cols.getOrDefault(j, new HashSet<>()));
                updatedColSet.add(current);
                cols.put(j, updatedColSet);

                String square = i / 3 + ", " + j / 3;
                if (squares.getOrDefault(square, new HashSet<>()).contains(current)) {
                    return false;
                }
                Set<Character> updatedSquareSet = new HashSet<>();
                updatedSquareSet.addAll(squares.getOrDefault(square, new HashSet<>()));
                updatedSquareSet.add(current);
                squares.put(square, updatedSquareSet);
            }
        }
        return true;
    }
}
