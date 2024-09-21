class Solution {
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

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    private void dfs(int current, int n, List<Integer> result) {
        if (current > n) {
            return;
        }
        result.add(current);
        for (int i = 0; i <= 9; i++) {
            dfs(current * 10 + i, n, result);
        }
    }
}