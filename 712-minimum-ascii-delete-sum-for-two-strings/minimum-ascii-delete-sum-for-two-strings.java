class Solution {

    int[][] memo;

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++)Arrays.fill(memo[i],-1);
        int commonSum = lcsAscii(0, 0, s1, s2);
        int total = 0;
        for (char c : s1.toCharArray()) total += c;
        for (char c : s2.toCharArray()) total += c;
        return total - 2 * commonSum;
    }

    private int lcsAscii(int i, int j, String s1, String s2) {
        if (i == s1.length() || j == s2.length())return 0;
        if (memo[i][j] != -1)return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = s1.charAt(i) + lcsAscii(i + 1, j + 1, s1, s2);
        } else {
            memo[i][j] = Math.max(
                    lcsAscii(i + 1, j, s1, s2),
                    lcsAscii(i, j + 1, s1, s2)
            );
        }
        return memo[i][j];
    }
}
