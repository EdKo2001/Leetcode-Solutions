class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1; // Points to the last valid element of nums1
        int right = n - 1; // Points to the last element of nums2
        int nums1Pointer = m + n - 1; // Points to the last position in nums1 (total length is m + n)

        // Merge in reverse order
        while (right >= 0) {
            if (left >= 0 && nums1[left] > nums2[right]) {
                nums1[nums1Pointer--] = nums1[left--];
            } else {
                nums1[nums1Pointer--] = nums2[right--];
            }
        }
    }
}
