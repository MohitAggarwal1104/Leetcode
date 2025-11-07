class Solution {
    public long maxPower(int[] stations, int r, long k) {
        int n = stations.length;

        // Step 1: compute initial power per city
        long[] diff = new long[n+1];
        for (int i = 0; i < n; i++) {
            long v = stations[i];
            int L = Math.max(0, i - r);
            int R = Math.min(n-1, i + r);
            diff[L] += v;
            diff[R + 1] -= v;
        }
        long[] power = new long[n];
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            power[i] = cur;
        }

        // Step 2: binary search
        long lo = 0, hi = (long)1e12;  // or something large enough
        while (lo < hi) {
            long mid = (lo + hi + 1) >>> 1;
            if (canAchieve(power, r, k, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean canAchieve(long[] power, int r, long k, long target) {
        int n = power.length;
        long[] addedDiff = new long[n+1];
        long addedSum = 0;

        for (int i = 0; i < n; i++) {
            addedSum += addedDiff[i];
            long current = power[i] + addedSum;
            if (current < target) {
                long deficit = target - current;
                if (deficit > k) return false;
                k -= deficit;
                int j = Math.min(n-1, i + r);
                int L2 = Math.max(0, j - r);
                int R2 = Math.min(n-1, j + r);
                addedDiff[L2] += deficit;
                addedDiff[R2 + 1] -= deficit;
                addedSum += deficit;
            }
        }
        return true;
    }
}
