class Solution {
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] leftDiag = new boolean[2 * n - 1];
        boolean[] rightDiag = new boolean[2 * n - 1];

        return solve(0, n, cols, leftDiag, rightDiag);
    }

    private int solve(int row, int n, boolean[] cols, boolean[] leftDiag, boolean[] rightDiag) {
        if (row == n) return 1; // found valid arrangement

        int count = 0;
        for (int col = 0; col < n; col++) {
            int ld = row - col + n - 1; // left diagonal index
            int rd = row + col;         // right diagonal index

            if (!cols[col] && !leftDiag[ld] && !rightDiag[rd]) {
                // place queen
                cols[col] = leftDiag[ld] = rightDiag[rd] = true;

                count += solve(row + 1, n, cols, leftDiag, rightDiag);

                // backtrack
                cols[col] = leftDiag[ld] = rightDiag[rd] = false;
            }
        }
        return count;
    }
}

// class Solution {
//     public int totalNQueens(int n) {
//         char[][] board = new char[n][n];
//         for (int i = 0; i < n; i++) {
//             Arrays.fill(board[i], '.');
//         }

//         return solve(0, board, n);
//     }

//     private int solve(int row, char[][] board, int n) {
//         if (row == n) {
//             return 1;  // found one valid arrangement
//         }

//         int count = 0;
//         for (int col = 0; col < n; col++) {
//             if (isSafe(board, row, col, n)) {
//                 board[row][col] = 'Q';
//                 count += solve(row + 1, board, n);
//                 board[row][col] = '.';  // backtrack
//             }
//         }
//         return count;
//     }

//     private boolean isSafe(char[][] board, int row, int col, int n) {
//         // check column
//         for (int i = 0; i < row; i++) {
//             if (board[i][col] == 'Q') return false;
//         }

//         // check left diagonal
//         for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
//             if (board[i][j] == 'Q') return false;
//         }

//         // check right diagonal
//         for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
//             if (board[i][j] == 'Q') return false;
//         }

//         return true;
//     }
// }
