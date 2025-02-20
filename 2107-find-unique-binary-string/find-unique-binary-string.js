/**
 * @param {string[]} nums
 * @return {string}
 */
var findDifferentBinaryString = function (nums) {
    let n = nums[0].length;
    const numbersSet = new Set(nums);
    let ans = "-1";

    const generateBinaryString = (str) => {
        if (str.length === n && !numbersSet.has(str)) {
            return ans = str;
        }
        if (str.length === n) return;
        for (let i = 0; i < 2; i++) {
            generateBinaryString(str + i);
        }
    }

    generateBinaryString("");

    return ans;
};