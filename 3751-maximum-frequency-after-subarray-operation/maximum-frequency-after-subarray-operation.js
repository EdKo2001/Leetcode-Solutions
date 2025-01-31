/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxFrequency = function (nums, k) {
    const n = nums.length;
    let baseCount = 0;
    for (let num of nums) {
        if (num === k) baseCount++;
    }

    let ans = baseCount;


    for (let v = 1; v <= 50; v++) {
        if (v === k) continue;

        let current = 0;
        let bestGain = 0;

        for (let i = 0; i < n; i++) {
            let delta = 0;
            if (nums[i] === v) {
                delta = 1;
            } else if (nums[i] === k) {
                delta = -1;
            }
            current = Math.max(delta, current + delta);
            bestGain = Math.max(bestGain, current);
        }

        ans = Math.max(ans, baseCount + bestGain);
    }

    return ans;
};