class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(new ArrayList<>(), 0, 0, candidates, target, res);
        return res;
    }

    public void helper(List<Integer> arr, int idx, int sum, int[] candidates, int target, List<List<Integer>> res) {
        // If sum exceeds the target, stop the recursion
        if (sum > target) {
            return;
        }

        // If sum equals the target, add a copy of the current combination to the result
        if (sum == target) {
            res.add(new ArrayList<>(arr)); // Add a new copy of arr
            return;
        }

        // Traverse the candidates
        for (int i = idx; i < candidates.length; i++) {
            arr.add(candidates[i]);
            // Recurse with updated sum and same index to allow using the same candidate
            helper(arr, i, sum + candidates[i], candidates, target, res);
            // Backtrack by removing the last added element
            arr.remove(arr.size() - 1);
        }
    }
}
