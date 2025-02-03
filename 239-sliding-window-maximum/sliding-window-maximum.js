/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function (nums, k) {
    const ans = [];
    const deque = [];

    for (let end = 0; end < nums.length; end++) {
        // Remove elements from the back if they are smaller than the current element
        while (deque.length && nums[deque[deque.length - 1]] < nums[end]) {
            deque.pop();
        }

        // Add the current index
        deque.push(end);

        // Remove the front element if it's out of the window range
        if (deque[0] < end - k + 1) {
            deque.shift();
        }

        // Start adding to the result once we reach a full window
        if (end >= k - 1) {
            ans.push(nums[deque[0]]);
        }
    }

    return ans;
};
