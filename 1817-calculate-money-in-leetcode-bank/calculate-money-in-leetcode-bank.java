class Solution {
    public int totalMoney(int n) {
        int count = 1;
        int total = 0;
        int daysInWeek = 7;
        int start = 1;

        for (int i = 1; i <= n; i++) {
            total += count;
            count++;

            if (i % daysInWeek == 0) { // end of week
                start++;
                count = start;
            }
        }

        return total;
    }
}