import java.util.*;

class Pair {
    int start;
    int end;
    Pair(int s, int e) {
        start = s;
        end = e;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        ArrayList<Pair> list = new ArrayList<>();
        for (int[] i : intervals) {
            list.add(new Pair(i[0], i[1]));
        }

        Collections.sort(list, (a, b) -> a.end - b.end);

        int count = 0;
        int prevEnd = Integer.MIN_VALUE;

        for (Pair p : list) {
            if (p.start >= prevEnd) {
                count++;
                prevEnd = p.end;
            }
        }

        return intervals.length - count;
    }
}
