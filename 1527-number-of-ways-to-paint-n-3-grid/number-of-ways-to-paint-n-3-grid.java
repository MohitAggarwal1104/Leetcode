class Solution {
    static final long MOD = 1000000007;
    Long[][] dp;  // dp[row][type]

    public int numOfWays(int n) {
        dp = new Long[n + 1][2];
        long typeA = solve(n, 0); // ABC
        long typeB = solve(n, 1); // ABA
        return (int)((typeA + typeB) % MOD);
    }

    // type: 0 → ABC pattern, 1 → ABA pattern
    private long solve(int row, int type) {
        // Base case: first row
        if (row == 1) {
            return type == 0 ? 6 : 6;
        }

        if (dp[row][type] != null) {
            return dp[row][type];
        }

        long result;
        if (type == 0) {
            // ABC
            result = (2 * solve(row - 1, 0) + 2 * solve(row - 1, 1)) % MOD;
        } else {
            // ABA
            result = (2 * solve(row - 1, 0) + 3 * solve(row - 1, 1)) % MOD;
        }

        dp[row][type] = result;
        return result;
    }
}
