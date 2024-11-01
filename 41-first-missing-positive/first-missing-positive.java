class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> dic = new HashSet<>();

        for (int num : nums) {
            dic.add(num);
        }

        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (!dic.contains(i))
                return i;
        }

        return n + 1;
    }
}