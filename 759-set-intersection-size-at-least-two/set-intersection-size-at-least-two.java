class Solution {
    public int intersectionSizeTwo(int[][] A) {

        Arrays.sort(A, (a, b) -> 
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );
        int p1 = -1, p2 = -1;
        int result = 0;

        for (int[] it : A) {
            int start = it[0];
            int end = it[1];

            if (p2 < start) {
                result += 2;
                p1 = end - 1;
                p2 = end;
            }
            else if (p1 < start) {
                result += 1;
                p1 = p2;
                p2 = end;
            }
        }

        return result;
    }
}
