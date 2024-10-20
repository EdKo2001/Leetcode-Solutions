class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        backtracking(new ArrayList<>(), res, nums, 0);
        
        return res;
    }

    public void backtracking(List<Integer> cur, List<List<Integer>> res, int[] nums, int idx) {
        res.add(new ArrayList<>(cur));
        
        // Iterate over all possible next elements starting from idx
        for (int i = idx; i < nums.length; i++) {
            // Include nums[i] in the current subset
            cur.add(nums[i]);
            
            // Recurse to build further subsets that include nums[i]
            backtracking(cur, res, nums, i + 1);
            
            // Backtrack: remove nums[i] to explore subsets without it
            cur.remove(cur.size() - 1);
        }
    }
}
