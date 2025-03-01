/**
 * @param {number[]} data
 * @return {number}
 */
var minSwaps = function (data) {
    const n = data.length;
    const totalOnes = data.reduce((sum, num) => sum + num, 0);

    if (totalOnes === 0 || totalOnes === n - 1) return 0;

    let onesInCurrentWindow = 0;

    for (let i = 0; i < totalOnes; i++) {
        if (data[i]) onesInCurrentWindow++;
    }

    let maxOnesInWindow = onesInCurrentWindow;

    for (let i = totalOnes; i < n; i++) {
        onesInCurrentWindow += data[i] - data[i - totalOnes];
        maxOnesInWindow = Math.max(maxOnesInWindow, onesInCurrentWindow)
    }

    return totalOnes - maxOnesInWindow;
};