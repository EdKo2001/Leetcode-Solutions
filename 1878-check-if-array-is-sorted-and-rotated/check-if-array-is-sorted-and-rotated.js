/**
 * @param {number[]} nums
 * @return {boolean}
 */
var check = function (nums) {
    let dropCount = 0;
    let n = nums.length;

    for (let i = 0; i < n; i++) {
        if (nums[i] > nums[(i + 1) % n]) {
            dropCount++;
        }
    }

    return dropCount <= 1;
};