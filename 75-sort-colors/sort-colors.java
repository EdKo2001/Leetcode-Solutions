class Solution {
    // Solution #1 (Two Pass)
    // public void sortColors(int[] nums) {
    //     int redIdx = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] == 0) {
    //             swap(nums, redIdx++, i);
    //         }
    //     }

    //     int whiteIdx = redIdx;
    //     for (int i = redIdx; i < nums.length; i++) {
    //         if (nums[i] == 1) {
    //             swap(nums, whiteIdx++, i);
    //         }
    //     }
    // }

    // private void swap(int[] nums, int idx1, int idx2) {
    //     int tmp = nums[idx1];
    //     nums[idx1] = nums[idx2];
    //     nums[idx2] = tmp;
    // }

    // Solution #2 (One Pass => Dutch National Flag algorithm)
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
