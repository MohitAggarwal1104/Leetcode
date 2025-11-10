class Solution {
    public boolean checkValidString(String s) {
        int leftBalance = 0, rightBalance = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*') leftBalance++;
            else leftBalance--;
            if (leftBalance < 0) return false;
        }
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*') rightBalance++;
            else rightBalance--;
            if (rightBalance < 0) return false;
        }

        return true;
    }
}
