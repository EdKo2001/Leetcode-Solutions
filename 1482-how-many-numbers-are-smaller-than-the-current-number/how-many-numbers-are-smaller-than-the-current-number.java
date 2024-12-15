class Solution {
    // public int[] smallerNumbersThanCurrent(int[] nums) {
    //     int[] sorted = nums.clone();
    //     Arrays.sort(sorted);

    //     Map<Integer, Integer> rankMap = new HashMap<>();

    //     for (int i = 0; i < sorted.length; i++) {
    //         rankMap.putIfAbsent(sorted[i], i);
    //     }

    //     int[] result = new int[nums.length];
    //     for (int i = 0; i < nums.length; i++) {
    //         result[i] = rankMap.get(nums[i]);
    //     }

    //     return result;
    // }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        // Frequency array (since nums[i] is in the range 0-100)
        int[] count = new int[101];
        
        // Step 1: Count the frequency of each number
        for (int num : nums) {
            count[num]++;
        }
        
        // Step 2: Compute the prefix sum for the count array
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }
        
        // Step 3: Build the result array
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // If nums[i] == 0, there are no smaller numbers
            result[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }
        
        return result;
    }
}