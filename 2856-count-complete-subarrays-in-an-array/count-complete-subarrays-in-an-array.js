/**
 * @param {number[]} nums
 * @return {number}
 */
function countCompleteSubarrays(nums) {
    const need = new Set(nums).size;      // # distinct values overall
    const freq = new Map();               // value → count inside window
    let have = 0;                         // # distinct values in window
    let left = 0;
    let ans = 0;

    for (let right = 0; right < nums.length; right++) {
        // add nums[right] to the window
        const rVal = nums[right];
        freq.set(rVal, (freq.get(rVal) ?? 0) + 1);
        if (freq.get(rVal) === 1) have++;   // new distinct value reached

        // if window already complete, shrink it as much as possible
        while (have === need) {
            ans += nums.length - right;       // every extension to the right works
            const lVal = nums[left++];
            freq.set(lVal, freq.get(lVal) - 1);
            if (freq.get(lVal) === 0) have--; // lost a distinct value
        }
    }
    return ans;
}
