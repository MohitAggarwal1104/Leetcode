class Solution {
    public long minOperations(int[][] queries) {
        long totalOps = 0;

        for (int[] q : queries) {
            int l = q[0], r = q[1];

            long steps = countUpTo(r) - countUpTo(l - 1);

            totalOps += (steps + 1) / 2;  // ceil(steps/2)
        }

        return totalOps;
    }

    // Count total steps needed for all numbers from 1..n
    private long countUpTo(long n) {
        if (n <= 0) return 0;

        long steps = 0;
        long base = 1;   // powers of 4
        int level = 1;

        while (base <= n) {
            long next = base * 4 - 1;  // max number at this level
            long upper = Math.min(n, next);
            long cnt = upper - base + 1;

            steps += cnt * level;

            base *= 4;
            level++;
        }

        return steps;
    }
}
