// import java.util.*;

// class Solution {
//     public int trimin(int i, int j, int dp[][], List<List<Integer>> triangle) {
//         if (i == triangle.size() - 1)
//             return triangle.get(i).get(j);

//         if (dp[i][j] != -1)
//             return dp[i][j];

//         int down = triangle.get(i).get(j) + trimin(i + 1, j, dp, triangle);
//         int diagonal = triangle.get(i).get(j) + trimin(i + 1, j + 1, dp, triangle);

//         return dp[i][j] = Math.min(down, diagonal);
//     }

//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int dp[][] = new int[n][n];

//         for (int[] row : dp)
//             Arrays.fill(row, -1);

//         return trimin(0, 0, dp, triangle);
//     }
// }
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // int n = triangle.size();
        // int dp[][] = new int[n][n];

        // for (int j = 0; j < n; j++) {
        //     dp[n - 1][j] = triangle.get(n - 1).get(j);
        // }

        // for (int i = n - 2; i >= 0; i--) {
        //     for (int j = 0; j <= i; j++) {
        //         int down = triangle.get(i).get(j) + dp[i + 1][j];
        //         int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];
        //         dp[i][j] = Math.min(down, diagonal);
        //     }
        // }

        // return dp[0][0];
        int n = triangle.size();
        int dp[] = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            int temp[] = new int[n];
            for (int j = 0; j <= i; j++) {
                int down = triangle.get(i).get(j) + dp[j];
                int diagonal = triangle.get(i).get(j) + dp[j + 1];
                temp[j] = Math.min(down, diagonal);
            }
            dp=temp;
        }

        return dp[0];
    }
}
