class Solution {
    // The time complexity remains O(n), where n is the length of the input array, as we iterate through the array once and use constant time operations to check and add to the set.
    // The space complexity is O(n) in the worst case, where all elements are distinct and stored in the set.
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}