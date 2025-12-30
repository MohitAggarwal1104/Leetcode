class Solution {
    boolean check(int[][] grid, int row, int col) {
        boolean[] has = new boolean[10];  // Track which numbers 1-9 are present
        int sum = 0;
        
        // Calculate main diagonal sum (this will be our target sum)
        for(int i = row, j = col; i < row + 3; i++, j++) {
            sum += grid[i][j];
        }
        
        // Check all rows
        for(int i = row; i < row + 3; i++) {
            int rowSum = 0;
            for(int j = col; j < col + 3; j++) {
                // Validate number is in range 1-9
                if(grid[i][j] < 1 || grid[i][j] > 9) return false;
                rowSum += grid[i][j];
                has[grid[i][j]] = true;  // Mark this number as seen
            }
            // All rows must equal the diagonal sum
            if(rowSum != sum) return false;
        }
        
        // Check all columns
        for(int i = col; i < col + 3; i++) {
            int colSum = 0;
            for(int j = row; j < row + 3; j++) {
                colSum += grid[j][i];
            }
            // All columns must equal the diagonal sum
            if(colSum != sum) return false;
        }
        
        // Ensure all numbers 1-9 are present (no duplicates, no missing)
        for(int i = 1; i < 10; i++) {
            if(!has[i]) return false;
        }
        
        // Check anti-diagonal (top-right to bottom-left)
        for(int i = row, j = col + 2; j >= col; i++, j--) {
            sum -= grid[i][j];
        }
        
        // If anti-diagonal equals main diagonal, sum should be 0
        return sum == 0;
    }
    
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        // Grid must be at least 3x3 to contain a magic square
        if(m < 3 || n < 3) return 0;
        
        // Check every possible 3x3 subgrid
        for(int i = 0; i < m - 2; i++) {
            for(int j = 0; j < n - 2; j++) {
                if(check(grid, i, j)) count++;
            }
        }
        
        return count;
    }
}