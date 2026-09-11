class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // use binary search to select target row
        int topRow = 0;
        int bottomRow = matrix.length - 1;
        int targetRow = -1;
        int n = matrix[0].length - 1; // will be used to select last element of a row in the matrix
        while (topRow <= bottomRow && targetRow == -1) {
            int middleRow = (topRow + bottomRow) / 2;
            if (target >= matrix[middleRow][0] && target <= matrix[middleRow][n]){
                targetRow = middleRow;
            } else if (target < matrix[middleRow][0]) {
                // check top half of matrix
                bottomRow = middleRow - 1;
            } else {
                // check bottom half of matrix
                topRow = middleRow + 1;
            }
        }
        if (targetRow == -1) return false;

        // search target row for target
        int l = 0, r = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target > matrix[targetRow][mid]) {
                //check right half
                l = mid + 1;
            } else if (target < matrix[targetRow][mid]) {
                // check left half
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
