class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> nums = new ArrayList<>();

        while (n > 0) {
            nums.add(String.valueOf(n));
            n--;
        }

        Collections.sort(nums);

        List<Integer> lexNums = new ArrayList<>();

        for (String num : nums) {
            lexNums.add(Integer.parseInt(num));
        }

        return lexNums;
    }
}