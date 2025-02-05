/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var nextGreaterElement = function (nums1, nums2) {
    const stack = [];
    const nextGreaterMap = new Map();

    for (const num of nums2) {
        // Maintain a decreasing stack
        while (stack.length > 0 && stack[stack.length - 1] < num) {
            nextGreaterMap.set(stack.pop(), num);
        }
        stack.push(num);
    }

    // Elements remaining in stack have no next greater element
    while (stack.length > 0) {
        nextGreaterMap.set(stack.pop(), -1);
    }

    return nums1.map(num => nextGreaterMap.get(num) || -1);
};
