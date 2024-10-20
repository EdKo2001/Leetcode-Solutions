class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtracking(new ArrayList<>(), res, nums);

        return res;
    }

    public void backtracking(List<Integer> curr, List<List<Integer>> res, int[] nums) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);

                backtracking(curr, res, nums);

                curr.remove(curr.size() - 1);
            }

        }
    }
}