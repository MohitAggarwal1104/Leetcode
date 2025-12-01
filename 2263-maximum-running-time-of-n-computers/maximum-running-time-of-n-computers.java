class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) {
            sum += b;
        }
        
        long low = 0;
        long high = sum / n;
        long ans = 0;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (canRun(mid, n, batteries)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
    
    private boolean canRun(long time, int n, int[] batteries) {
        long total = 0;
        for (int b : batteries) {
            total += Math.min(b, time);
            if (total >= (long) n * time) {
                return true;
            }
        }
        return total >= (long) n * time;
    }
}
