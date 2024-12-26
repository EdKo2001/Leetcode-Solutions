class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() > 0 && Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(stack.peek())
                    && s.charAt(i) != stack.peek()) {
                stack.pop();
            } else
                stack.add(s.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : stack)
            ans.append(ch);
        return ans.toString();
    }

}