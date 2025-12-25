public class Solution {

    int n, m;
    int[][] grid;
    boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return dfs(i, j); // start DFS from first land cell
                }
            }
        }
        return 0;
    }

    private int dfs(int i, int j) {
        // Out of boundary
        if (i < 0 || j < 0 || i >= n || j >= m)
            return 1;

        // Water cell
        if (grid[i][j] == 0)
            return 1;

        // Already visited land
        if (visited[i][j])
            return 0;

        visited[i][j] = true;

        int perimeter = 0;
        perimeter += dfs(i, j - 1); // left
        perimeter += dfs(i - 1, j); // up
        perimeter += dfs(i, j + 1); // right
        perimeter += dfs(i + 1, j); // down

        return perimeter;
    }
}
