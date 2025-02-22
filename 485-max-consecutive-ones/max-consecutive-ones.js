/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function (nums) {
    let maxConsecutive = 0;
    let count = 0;

    for (let num of nums) {
        if (num === 1) {
            count++;
            maxConsecutive = Math.max(maxConsecutive, count);
        } else {
            count = 0;
        }
    }

    return maxConsecutive;
};
