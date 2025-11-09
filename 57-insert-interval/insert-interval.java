import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null) return new int[0][];
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;
        int start = newInterval[0], end = newInterval[1];

        while (i < n && intervals[i][1] < start) {
            res.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[]{start, end});

        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
