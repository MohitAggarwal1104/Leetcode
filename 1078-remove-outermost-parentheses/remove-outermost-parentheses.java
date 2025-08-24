class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0) sb.append(c); // not outermost
                depth++;
            } else { // c == ')'
                depth--;
                if (depth > 0) sb.append(c); // not outermost
            }
        }
        return sb.toString();
    }
}
