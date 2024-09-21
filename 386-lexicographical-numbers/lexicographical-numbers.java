class Solution {
    // Time complexity: O(nlogn)
    // Space complexity: O(n)
    // public List<Integer> lexicalOrder(int n) {
    // List<String> nums = new ArrayList<>();

    // while (n > 0) {
    // nums.add(String.valueOf(n));
    // n--;
    // }

    // Collections.sort(nums);

    // List<Integer> lexNums = new ArrayList<>();

    // for (String num : nums) {
    // lexNums.add(Integer.parseInt(num));
    // }

    // return lexNums;
    // }

    // DFS Approach, Recursive
    // Time complexity: O(n)
    // Space complexity: O(n)
    // public List<Integer> lexicalOrder(int n) {
    // List<Integer> result = new ArrayList<>();
    // for (int i = 1; i <= 9; i++) {
    // dfs(i, n, result);
    // }
    // return result;
    // }

    // private void dfs(int current, int n, List<Integer> result) {
    // if (current > n) {
    // return;
    // }
    // result.add(current);
    // for (int i = 0; i <= 9; i++) {
    // dfs(current * 10 + i, n, result);
    // }
    // }

    // Iterative
    // Time complexity: O(n)
    // Space complexity: O(n)
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int current = 1;

        for (int i = 1; i <= n; i++) {
            result.add(current);
            if (current * 10 <= n) {
                // Go down to the next level (e.g., 1 -> 10)
                current *= 10;
            } else {
                // If current ends with a 9 or exceeds n, move up and increase by 1
                while (current % 10 == 9 || current + 1 > n) {
                    current /= 10; // Go up one level (e.g., 19 -> 1)
                }
                current++; // Move to the next number (e.g., 1 -> 2)
            }
        }

        return result;
    }
}