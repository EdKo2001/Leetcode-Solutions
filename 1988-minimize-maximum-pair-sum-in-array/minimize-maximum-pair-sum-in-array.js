/**
 * @param {number[]} nums
 * @return {number}
 */
var minPairSum = function (nums) {
    // Find the minimum and maximum values in the array.
    let minVal = Math.min(...nums);
    let maxVal = Math.max(...nums);
    const range = maxVal - minVal + 1;

    // Create a frequency array for the range of values.
    const freq = new Array(range).fill(0);
    for (let num of nums) {
        freq[num - minVal]++;
    }

    // Reconstruct the sorted array using the frequency array.
    const sorted = new Array(nums.length);
    let index = 0;
    for (let i = 0; i < range; i++) {
        while (freq[i] > 0) {
            sorted[index++] = i + minVal;
            freq[i]--;
        }
    }

    // Now, pair the smallest with the largest.
    let maxPair = 0;
    const n = sorted.length;
    for (let i = 0; i < n / 2; i++) {
        maxPair = Math.max(maxPair, sorted[i] + sorted[n - i - 1]);
    }

    return maxPair;
};