public class Solution {

    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        // Traverse through the expression
        for (char currChar : expression.toCharArray()) {
            if (currChar == ',' || currChar == '(')
                continue; // Skip commas and open parentheses

            // Push operators and boolean values to the stack
            if (currChar == 't' ||
                    currChar == 'f' ||
                    currChar == '!' ||
                    currChar == '&' ||
                    currChar == '|') {
                st.push(currChar);
            }
            // Handle closing parentheses and evaluate the subexpression
            else if (currChar == ')') {
                boolean hasTrue = false, hasFalse = false;

                // Process the values inside the parentheses
                while (st.peek() != '!' && st.peek() != '&' && st.peek() != '|') {
                    char topValue = st.pop();
                    if (topValue == 't')
                        hasTrue = true;
                    if (topValue == 'f')
                        hasFalse = true;
                }

                // Pop the operator and evaluate the subexpression
                char op = st.pop();
                if (op == '!') {
                    st.push(hasTrue ? 'f' : 't');
                } else if (op == '&') {
                    st.push(hasFalse ? 'f' : 't');
                } else {
                    st.push(hasTrue ? 't' : 'f');
                }
            }
        }

        // The final result is at the top of the stack
        return st.peek() == 't';
    }
}