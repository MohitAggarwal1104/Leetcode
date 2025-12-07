class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for(char ch : expression.toCharArray()) {

            if (ch == ',') continue;

            if (ch == 't' || ch == 'f' || ch == '!' || ch == '&' || ch == '|' || ch == '(') {
                st.push(ch);
            }

            else if (ch == ')') {

                // Collect all values inside the parentheses
                boolean hasTrue = false;
                boolean hasFalse = false;

                while (st.peek() != '(') {
                    char val = st.pop();
                    if (val == 't') hasTrue = true;
                    else hasFalse = true;
                }

                st.pop(); // remove '('
                char op = st.pop(); // operator

                boolean result = false;

                if (op == '!') {
                    result = !hasTrue;    // only 1 inner expression
                }
                else if (op == '&') {
                    result = !hasFalse;   // AND is true only if no false
                }
                else if (op == '|') {
                    result = hasTrue;     // OR is true if any true
                }

                st.push(result ? 't' : 'f');
            }
        }

        return st.pop() == 't';
    }
}
