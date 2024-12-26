class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek().getValue() <= temperatures[i]) {
                stack.pop();
            }
            ans[i] = stack.size() > 0 ? stack.peek().getKey() - i : 0;
            stack.add(new Pair<>(i, temperatures[i]));
        }
        return ans;
    }
}