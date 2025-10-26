class Solution {
    public int myAtoi(String s) {
        int i = 0;
        boolean negative = false;
        int count = 1;

        s = s.trim();
        if (s.isEmpty()) return 0;

        for (char p : s.toCharArray()) {
            if ((p == '-' || p == '+') && count == 1) {
                if (p == '-') negative = true;
                count++;
                continue;
            }

            if (Character.isDigit(p)) {
                if (i > (Integer.MAX_VALUE - (p - '0')) / 10) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }

                i = i * 10 + (p - '0');
                count++;
            } else {
                if (negative) i *= -1;
                return i;
            }
        }

        if (negative) i *= -1;
        return i;
    }
}
