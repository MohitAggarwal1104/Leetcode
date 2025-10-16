import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] leftDiag = new boolean[2 * n - 1];
        boolean[] rightDiag = new boolean[2 * n - 1];

        solve(0, n, board, result, cols, leftDiag, rightDiag);
        return result;
    }

    private void solve(int row, int n, char[][] board, List<List<String>> result,
                       boolean[] cols, boolean[] leftDiag, boolean[] rightDiag) {

        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int ld = row - col + n - 1;  // left diagonal index
            int rd = row + col;          // right diagonal index

            if (!cols[col] && !leftDiag[ld] && !rightDiag[rd]) {
                // place queen
                board[row][col] = 'Q';
                cols[col] = leftDiag[ld] = rightDiag[rd] = true;

                // next row
                solve(row + 1, n, board, result, cols, leftDiag, rightDiag);

                // backtrack
                board[row][col] = '.';
                cols[col] = leftDiag[ld] = rightDiag[rd] = false;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (char[] row : board) {
            path.add(new String(row));
        }
        return path;
    }
}

// import java.util.*;

// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> result = new ArrayList<>();
//         char[][] board = new char[n][n];

//         // Initialize board with '.'
//         for (int i = 0; i < n; i++) {
//             Arrays.fill(board[i], '.');
//         }

//         solve(0, board, result, n);
//         return result;
//     }

//     private void solve(int row, char[][] board, List<List<String>> result, int n) {
//         if (row == n) {
//             result.add(construct(board));
//             return;
//         }

//         for (int col = 0; col < n; col++) {
//             if (isSafe(board, row, col, n)) {
//                 board[row][col] = 'Q';
//                 solve(row + 1, board, result, n);
//                 board[row][col] = '.';  // backtrack
//             }
//         }
//     }

//     private boolean isSafe(char[][] board, int row, int col, int n) {
//         // Check column
//         for (int i = 0; i < row; i++) {
//             if (board[i][col] == 'Q') return false;
//         }

//         // Check left diagonal
//         for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
//             if (board[i][j] == 'Q') return false;
//         }

//         // Check right diagonal
//         for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
//             if (board[i][j] == 'Q') return false;
//         }

//         return true;
//     }

//     private List<String> construct(char[][] board) {
//         List<String> path = new ArrayList<>();
//         for (char[] row : board) {
//             path.add(new String(row));
//         }
//         return path;
//     }
// }
