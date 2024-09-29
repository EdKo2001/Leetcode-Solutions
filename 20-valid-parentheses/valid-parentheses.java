class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.add(')');
            } else if (ch == '{') {
                stack.add('}');
            } else if (ch == '[') {
                stack.add(']');
            } else {
                if (stack.size() == 0)
                    return false;
                char item = stack.pop();
                if (item != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();

        // Stack<Character> brackets = new Stack<>();
        // Map<Character, Character> bracketLookup = new HashMap<>(3);

        // bracketLookup.put(')', '(');
        // bracketLookup.put('}', '{');
        // bracketLookup.put(']', '[');

        // for (int i = 0; i < s.length(); i++) {
        // char c = s.charAt(i);
        // if (bracketLookup.containsKey(c)) {
        // if (!brackets.isEmpty() && bracketLookup.get(c).equals(brackets.peek())) {
        // brackets.pop();
        // } else {
        // return false;
        // }
        // } else {
        // brackets.push(c);
        // }
        // }

        // return brackets.isEmpty();
    }
}