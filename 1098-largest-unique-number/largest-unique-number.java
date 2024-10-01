class Solution {
    public int largestUniqueNumber(int[] nums) {
        int largestUnique = -1;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) == 1 && num > largestUnique) {
                largestUnique = num;
            }
        }

        return largestUnique;
    }
}