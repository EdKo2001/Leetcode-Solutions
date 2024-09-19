class Solution {
    // public void rotate(int[] nums, int k) {
    //     int n = nums.length; // if k is greater than nums.length then one cycle is completed that means it will remain the same and we have to remainder shifts
    //     k = k % n;
    //     int[] rotated = new int[n];

    //     for (int i = 0; i < n; i++) {
    //         rotated[(i + k) % n] = nums[i];
    //     }

    //     for (int i = 0; i < n; i++) {
    //         nums[i] = rotated[i];
    //     }        
    // }

    public void rotate(int[] nums, int k) {
        k %= nums.length; // if k is greater than nums.length then one cycle is completed that means it will remain the same and we have to remainder shifts

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }    
}