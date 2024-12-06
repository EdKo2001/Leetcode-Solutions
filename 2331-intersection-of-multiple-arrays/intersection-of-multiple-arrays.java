class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int[] array : nums) {
            for (int num : array) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        int numArrays = nums.length;
        for (int num : countMap.keySet()) {
            if (countMap.get(num) == numArrays) {
                result.add(num);
            }
        }

        Collections.sort(result);
        return result;
    }
}