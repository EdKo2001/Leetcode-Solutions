/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var countGood = function (nums, k) {
    let left = 0, right = 0, freq = new Map(), count = 0, total = 0;

    while (right < nums.length) {
        const rNum = nums[right];
        let f = freq.get(rNum) || 0;
        total += f;
        freq.set(rNum, f + 1);
        right++;

        while (total >= k) {
            count += nums.length - right + 1;
            const lNum = nums[left];
            freq.set(lNum, freq.get(lNum) - 1);
            total -= freq.get(lNum);
            left++;
        }
    }

    return count;
};
