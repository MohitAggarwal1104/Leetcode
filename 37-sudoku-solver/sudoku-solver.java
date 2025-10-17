class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // Helper recursive function
    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') { // empty cell
                    for (char num = '1'; num <= '9'; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num; // choose
                            if (solve(board)) // explore
                                return true;
                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false; // no number fits
                }
            }
        }
        return true; // all cells filled
    }

    private boolean isSafe(char[][] board, int row, int col, char num) {
        // Check row & column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }

        // Check 3x3 subgrid
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}
