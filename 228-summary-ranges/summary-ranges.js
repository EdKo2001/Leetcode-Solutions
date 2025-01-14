/**
 * @param {number[]} nums
 * @return {string[]}
 */
var summaryRanges = function (nums) {
    if (nums.length === 0) return [];

    const res = [];
    let start = 0;
    for (let end = 1; end < nums.length; end++) {
        if (nums[end] != nums[end - 1] + 1) {
            res.push(start !== end - 1 ? `${nums[start]}->${nums[end - 1]}` : `${nums[end - 1]}`);
            start = end;
        }
    }

    res.push(start === nums.length - 1 ? `${nums[start]}` : `${nums[start]}->${nums[nums.length - 1]}`);

    return res;
};